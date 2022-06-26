package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.MatchDto;
import com.example.oddsmathfetcher.persistance.entity.Match;
import com.example.oddsmathfetcher.persistance.mapper.LeagueMapper;
import com.example.oddsmathfetcher.persistance.mapper.MatchMapper;
import com.example.oddsmathfetcher.persistance.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @apiNote Match without bookmaker and odds.
 */
@Primary
@Component
public class MatchMapperImpl implements MatchMapper {

    private TeamMapper teamMapper;
    private LeagueMapper leagueMapper;

    @Autowired
    private void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Autowired
    private void setLeagueMapper(LeagueMapper leagueMapper) {
        this.leagueMapper = leagueMapper;
    }

    @Override
    public Match toEntity(MatchDto dto) {
        if (dto == null) {
            return null;
        }

        Match match = new Match();

        match.setId(dto.getId());
        match.setTime(dto.getTime());

        match.setHomeTeam(teamMapper.toEntity(dto.getHomeTeam()));
        match.setAwayTeam(teamMapper.toEntity(dto.getAwayTeam()));

        match.setLeague(leagueMapper.toEntity(dto.getLeague()));
        //match.setBookmakerMatchList(bookmakerMatchDtoListToBookmakerMatchList(dto.getBookmakerMatchList()));

        return match;
    }

    @Override
    public MatchDto toDto(Match entity) {
        if (entity == null) {
            return null;
        }

        MatchDto matchDto = new MatchDto();

        matchDto.setCreatedDate(entity.getCreatedDate());
        matchDto.setId(entity.getId());
        matchDto.setTime(entity.getTime());

        matchDto.setHomeTeam(teamMapper.toDto(entity.getHomeTeam()));
        matchDto.setAwayTeam(teamMapper.toDto(entity.getAwayTeam()));

        matchDto.setLeague(leagueMapper.toDto(entity.getLeague()));
        //matchDto.setBookmakerMatchList(bookmakerMatchListToBookmakerMatchDtoList(entity.getBookmakerMatchList()));

        return matchDto;
    }

    @Override
    public List<Match> toEntity(List<MatchDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Match> list = new ArrayList<>(dtoList.size());
        for (MatchDto matchDto : dtoList) {
            list.add(toEntity(matchDto));
        }

        return list;
    }

    @Override
    public List<MatchDto> toDto(List<Match> entityList) {
        if (entityList == null) {
            return null;
        }

        List<MatchDto> list = new ArrayList<>(entityList.size());
        for (Match match : entityList) {
            list.add(toDto(match));
        }

        return list;
    }

    @Override
    public Set<MatchDto> toDto(Set<Match> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<MatchDto> set = new HashSet<>();
        for (Match match : entityList) {
            set.add(toDto(match));
        }

        return set;
    }
}
