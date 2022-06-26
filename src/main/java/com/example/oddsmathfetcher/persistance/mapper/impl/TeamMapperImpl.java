package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.TeamDto;
import com.example.oddsmathfetcher.persistance.entity.Team;
import com.example.oddsmathfetcher.persistance.mapper.CountryMapper;
import com.example.oddsmathfetcher.persistance.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TeamMapperImpl implements TeamMapper {

    private CountryMapper countryMapper;

    @Autowired
    void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public Team toEntity(TeamDto dto) {
        if (dto == null) {
            return null;
        }

        Team team = new Team();

        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setCountry(countryMapper.toEntity(dto.getCountry()));

        return team;
    }

    @Override
    public TeamDto toDto(Team entity) {
        if (entity == null) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId(entity.getId());
        teamDto.setName(entity.getName());
        teamDto.setCreatedDate(entity.getCreatedDate());
        teamDto.setCountry(countryMapper.toDto(entity.getCountry()));

        return teamDto;
    }

    @Override
    public List<Team> toEntity(List<TeamDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Team> list = new ArrayList<>(dtoList.size());
        for (TeamDto teamDto : dtoList) {
            list.add(toEntity(teamDto));
        }

        return list;
    }

    @Override
    public List<TeamDto> toDto(List<Team> entityList) {
        if (entityList == null) {
            return null;
        }

        List<TeamDto> list = new ArrayList<>(entityList.size());
        for (Team team : entityList) {
            list.add(toDto(team));
        }

        return list;
    }

    @Override
    public Set<TeamDto> toDto(Set<Team> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<TeamDto> set = new HashSet<>();
        for (Team team : entityList) {
            set.add(toDto(team));
        }

        return set;
    }
}
