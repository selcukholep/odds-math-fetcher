package com.example.oddsmathfetcher;

import com.example.oddsmathfetcher.client.OddsMathClient;
import com.example.oddsmathfetcher.client.raw.RawEvent;
import com.example.oddsmathfetcher.client.raw.RawEventsByDay;
import com.example.oddsmathfetcher.client.raw.RawLeague;
import com.example.oddsmathfetcher.client.raw.RawMatch;
import com.example.oddsmathfetcher.domain.dto.*;
import com.example.oddsmathfetcher.domain.service.MatchFetcherService;
import com.example.oddsmathfetcher.persistance.factory.OddsMapperFactory;
import com.example.oddsmathfetcher.persistance.service.MatchService;
import com.example.oddsmathfetcher.persistance.type.OddsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@EnableAsync
public class OddsMathFetcherApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OddsMathFetcherApplication.class, args);
    }

    @Autowired
    MatchFetcherService matchFetcherService;

    @Autowired
    OddsMathClient oddsMathClient;

    @Autowired
    MatchService matchService;

    @Autowired
    OddsMapperFactory oddsMapperFactory;

    @Override
    public void run(String... args) throws Exception {

//        RawEventsByDay rawMatches = oddsMathClient.getEventsByDay("2022-06-26");
//
//        rawMatches.getLeagueMap().values()
//                .stream()
//                .filter(rawLeague -> rawLeague.getCountry_name() == null)
//                .forEach(rawLeague -> rawLeague.setCountry_name("International"));
//
//        List<RawEvent> rawEvents = rawMatches.getLeagueMap()
//                .values()
//                .stream()
//                .map(RawLeague::getEvents)
//                .map(Map::entrySet).toList()
//                .stream()
//                .flatMap(Collection::stream)
//                .map(Map.Entry::getValue).toList();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        rawEvents.parallelStream().forEach((rawEvent -> {
//            RawMatch rawMatch = oddsMathClient.getEvent(rawEvent.getId(), OddsType.FINAL_TIME_FULL.value());
//
//            MatchDto matchDto = new MatchDto();
//            matchDto.setId(rawEvent.getId());
//
//            matchDto.setAwayTeam(new TeamDto(rawMatch.getRawMatchDetail().getAwayteam().getId(),
//                    rawMatch.getRawMatchDetail().getAwayteam().getName(),
//                    new CountryDto(rawMatch.getRawMatchDetail().getAwayteam().getCountry_id(),
//                            rawMatch.getRawMatchDetail().getAwayteam().getCountry_name())));
//
//            matchDto.setHomeTeam(new TeamDto(rawMatch.getRawMatchDetail().getHometeam().getId(),
//                    rawMatch.getRawMatchDetail().getHometeam().getName(),
//                    new CountryDto(rawMatch.getRawMatchDetail().getHometeam().getCountry_id(),
//                            rawMatch.getRawMatchDetail().getHometeam().getCountry_name())));
//
//            RawLeague rawLeague = rawMatches.getLeagueMap().get(String.valueOf(rawEvent.getLeague_id()));
//            matchDto.setLeague(new LeagueDto(rawEvent.getLeague_id(),
//                    rawLeague.getName(),
//                    new CountryDto(rawLeague.getCountry_id(),
//                            rawLeague.getCountry_name())));
//
//
//            matchDto.setTime(LocalDateTime.parse(rawMatch.getRawMatchDetail().getTime(), formatter).atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());
//
//            matchDto.setBookmakerMatchList(new ArrayList<>());
//            rawMatch.getRawMatchBookmakerMap().forEach((s, rawMatchBookmaker) -> {
//                BookmakerDto bookmakerDto = new BookmakerDto(rawMatchBookmaker.getxId(), s);
//
//                BookmakerMatchDto bookmakerMatchDto = new BookmakerMatchDto();
//                bookmakerMatchDto.setOddsType(OddsType.FINAL_TIME_FULL);
//                bookmakerMatchDto.setBookmaker(bookmakerDto);
//                bookmakerMatchDto.setActive(rawMatchBookmaker.isActive());
//                bookmakerMatchDto.setLastUpdatedDate(LocalDateTime.parse(rawMatchBookmaker.getUpdated()).atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());
//                bookmakerMatchDto.setLiveBetting(rawMatchBookmaker.isLiveBetting());
//                bookmakerMatchDto.setMatch(matchDto);
//                bookmakerMatchDto.setId(bookmakerMatchDto.getBookmaker().getId() + "" +
//                        bookmakerMatchDto.getOddsType().ordinal() + "" +
//                        bookmakerMatchDto.getMatch().getId());
//
//                bookmakerMatchDto.setOdds(new ArrayList<>());
//                if (rawMatchBookmaker.getHistory() != null) {
//                    rawMatchBookmaker.getHistory().forEach(stringObjectMap -> {
//                        OddsDto oddsDto = oddsMapperFactory.getMapper(bookmakerMatchDto.getOddsType()).instance();
//                        oddsDto.setId(stringObjectMap.get("uid").toString());
//
//                        oddsDto.setUpdatedDate(LocalDateTime.parse(stringObjectMap.get("updated").toString(), formatter)
//                                .atZone(ZoneId.of("Europe/Istanbul")).toLocalDateTime());
//
//                        oddsMapperFactory.getMapper(bookmakerMatchDto.getOddsType())
//                                .mapValues(oddsDto, stringObjectMap);
//                        bookmakerMatchDto.getOdds().add(oddsDto);
//                    });
//                }
//
//                matchDto.getBookmakerMatchList().add(bookmakerMatchDto);
//
//            });
//
//            matchService.save(matchDto);
//
//            System.out.println("Stop");
//        }));
//
//        System.out.println("matchDto");

    }
}
