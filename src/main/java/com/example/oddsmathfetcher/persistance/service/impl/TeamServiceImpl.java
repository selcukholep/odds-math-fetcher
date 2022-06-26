package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.TeamDto;
import com.example.oddsmathfetcher.persistance.mapper.TeamMapper;
import com.example.oddsmathfetcher.persistance.repository.TeamRepository;
import com.example.oddsmathfetcher.persistance.service.CountryService;
import com.example.oddsmathfetcher.persistance.service.TeamService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    final TeamRepository teamRepository;
    final TeamMapper teamMapper;
    final CountryService countryService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper, CountryService countryService) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.countryService = countryService;
    }

    @Override
    public TeamDto get(int id) {
        return teamMapper.toDto(teamRepository.getById(id));
    }

    @Override
    public void save(TeamDto teamDto) {
        try {
            teamRepository.save(teamMapper.toEntity(teamDto));
        } catch (DataIntegrityViolationException e) {
            countryService.save(teamDto.getCountry());
            teamRepository.save(teamMapper.toEntity(teamDto));
        }
    }
}
