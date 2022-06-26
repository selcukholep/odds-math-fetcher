package com.example.oddsmathfetcher.domain.service;

import com.example.oddsmathfetcher.client.OddsMathClient;
import com.example.oddsmathfetcher.client.raw.RawEvent;
import com.example.oddsmathfetcher.client.raw.RawEventsByDay;
import com.example.oddsmathfetcher.client.raw.RawMatch;
import com.example.oddsmathfetcher.domain.dto.*;
import com.example.oddsmathfetcher.domain.publisher.MatchPublisher;
import com.example.oddsmathfetcher.domain.request.FetchFilterRequest;
import com.example.oddsmathfetcher.persistance.factory.OddsMapperFactory;
import com.example.oddsmathfetcher.persistance.type.OddsType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchFetcherServiceImpl implements MatchFetcherService {

    final OddsMathClient oddsMathClient;
    final MatchPublisher matchPublisher;
    final OddsMapperFactory oddsMapperFactory;
    final DateTimeFormatter formatter;

    public MatchFetcherServiceImpl(OddsMathClient oddsMathClient,
                                   MatchPublisher matchPublisher,
                                   OddsMapperFactory oddsMapperFactory) {
        this.oddsMathClient = oddsMathClient;
        this.matchPublisher = matchPublisher;
        this.oddsMapperFactory = oddsMapperFactory;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public void fetchAndPublishMatches(String day, FetchFilterRequest request) {
        RawEventsByDay rawEvents = oddsMathClient.getEventsByDay(day);
        fixInternational(rawEvents);

        List<MatchDto> matchDtoList = parseMatches(rawEvents, request.getOddsTypes());

        matchDtoList.forEach(matchPublisher::publishFetchedMatch);
    }

    private List<MatchDto> parseMatches(RawEventsByDay rawEvents, List<OddsType> requestOddsTypes) {

        List<MatchDto> matchDtoList = new ArrayList<>();

        rawEvents.getLeagueMap().values().parallelStream().forEach(rawLeague -> {

            matchDtoList.addAll(
                    rawLeague.getEvents().values().stream()
                            .map(rawEvent -> {
                                MatchDto matchDto = new MatchDto();
                                matchDto.setId(rawEvent.getId());
                                matchDto.setTime(LocalDateTime.parse(rawEvent.getTime(), formatter)
                                        .atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());
                                matchDto.setAwayTeam(new TeamDto(rawEvent.getAwayteam_id(),
                                        rawEvent.getAwayteam_name(),
                                        new CountryDto(rawEvent.getAwayteam_country_id(),
                                                rawEvent.getAwayteam_country())));

                                matchDto.setHomeTeam(new TeamDto(rawEvent.getHometeam_id(),
                                        rawEvent.getHometeam_name(),
                                        new CountryDto(rawEvent.getHometeam_country_id(),
                                                rawEvent.getHometeam_country())));

                                matchDto.setLeague(new LeagueDto(rawEvent.getLeague_id(), rawLeague.getName(),
                                        new CountryDto(rawLeague.getCountry_id(),
                                                rawLeague.getCountry_name())));

                                matchDto.setBookmakerMatchList(new ArrayList<>());

                                requestOddsTypes.forEach(oddsType -> fetchOdds(rawEvent, matchDto, oddsType));

                                return matchDto;
                            }).toList());
        });

        return matchDtoList;
    }

    private void fetchOdds(RawEvent rawEvent, MatchDto matchDto, OddsType oddsType) {

        RawMatch rawMatch = oddsMathClient.getEvent(rawEvent.getId(), oddsType.value());

        rawMatch.getRawMatchBookmakerMap().forEach((s, rawMatchBookmaker) -> {
            BookmakerDto bookmakerDto = new BookmakerDto(rawMatchBookmaker.getxId(), s);

            BookmakerMatchDto bookmakerMatchDto = new BookmakerMatchDto();
            bookmakerMatchDto.setOddsType(oddsType);
            bookmakerMatchDto.setBookmaker(bookmakerDto);
            bookmakerMatchDto.setActive(rawMatchBookmaker.isActive());
            bookmakerMatchDto.setLastUpdatedDate(LocalDateTime.parse(rawMatchBookmaker.getUpdated())
                    .atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());
            bookmakerMatchDto.setLiveBetting(rawMatchBookmaker.isLiveBetting());
            bookmakerMatchDto.setMatch(matchDto);
            bookmakerMatchDto.setId(bookmakerMatchDto.getBookmaker().getId() + "" +
                    bookmakerMatchDto.getOddsType().ordinal() + "" +
                    bookmakerMatchDto.getMatch().getId());

            bookmakerMatchDto.setOdds(new ArrayList<>());
            if (rawMatchBookmaker.getHistory() != null) {
                rawMatchBookmaker.getHistory().forEach(stringObjectMap -> {
                    OddsDto oddsDto = oddsMapperFactory.getMapper(bookmakerMatchDto.getOddsType()).instance();
                    oddsDto.setId(stringObjectMap.get("uid").toString());

                    oddsDto.setUpdatedDate(LocalDateTime.parse(stringObjectMap.get("updated").toString(), formatter)
                            .atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());

                    oddsMapperFactory.getMapper(bookmakerMatchDto.getOddsType())
                            .mapValues(oddsDto, stringObjectMap);
                    bookmakerMatchDto.getOdds().add(oddsDto);
                });
            }

            matchDto.getBookmakerMatchList().add(bookmakerMatchDto);
        });
    }

    private void fixInternational(RawEventsByDay rawEventsByDay) {
        rawEventsByDay.getLeagueMap().values()
                .stream()
                .filter(rawLeague -> rawLeague.getCountry_name() == null)
                .forEach(rawLeague -> rawLeague.setCountry_name("International"));
    }
}
