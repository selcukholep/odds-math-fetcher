package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.LeagueDto;
import com.example.oddsmathfetcher.persistance.entity.League;
import com.example.oddsmathfetcher.persistance.mapper.CountryMapper;
import com.example.oddsmathfetcher.persistance.mapper.LeagueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LeagueMapperImpl implements LeagueMapper {

    private CountryMapper countryMapper;

    @Autowired
    void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public League toEntity(LeagueDto dto) {
        if (dto == null) {
            return null;
        }

        League league = new League();

        league.setId(dto.getId());
        league.setName(dto.getName());

        league.setCountry(countryMapper.toEntity(dto.getCountry()));

        return league;
    }

    @Override
    public LeagueDto toDto(League entity) {
        if (entity == null) {
            return null;
        }

        LeagueDto leagueDto = new LeagueDto();

        leagueDto.setId(entity.getId());
        leagueDto.setName(entity.getName());
        leagueDto.setCreatedDate(entity.getCreatedDate());
        leagueDto.setCountry(countryMapper.toDto(entity.getCountry()));

        return leagueDto;
    }

    @Override
    public List<League> toEntity(List<LeagueDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<League> list = new ArrayList<>(dtoList.size());
        for (LeagueDto leagueDto : dtoList) {
            list.add(toEntity(leagueDto));
        }

        return list;
    }

    @Override
    public List<LeagueDto> toDto(List<League> entityList) {
        if (entityList == null) {
            return null;
        }

        List<LeagueDto> list = new ArrayList<>(entityList.size());
        for (League league : entityList) {
            list.add(toDto(league));
        }

        return list;
    }

    @Override
    public Set<LeagueDto> toDto(Set<League> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<LeagueDto> set = new HashSet<>();
        for (League league : entityList) {
            set.add(toDto(league));
        }

        return set;
    }
}
