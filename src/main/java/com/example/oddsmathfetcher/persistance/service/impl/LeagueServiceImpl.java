package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.LeagueDto;
import com.example.oddsmathfetcher.persistance.mapper.LeagueMapper;
import com.example.oddsmathfetcher.persistance.repository.LeagueRepository;
import com.example.oddsmathfetcher.persistance.service.CountryService;
import com.example.oddsmathfetcher.persistance.service.LeagueService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService {

    final LeagueRepository leagueRepository;
    final LeagueMapper leagueMapper;
    final CountryService countryService;

    public LeagueServiceImpl(LeagueRepository leagueRepository, LeagueMapper leagueMapper, CountryService countryService) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
        this.countryService = countryService;
    }

    @Override
    public LeagueDto get(int id) {
        return leagueMapper.toDto(leagueRepository.getById(id));
    }

    @Override
    public void save(LeagueDto leagueDto) {
        try {
            leagueRepository.save(leagueMapper.toEntity(leagueDto));
        } catch (DataIntegrityViolationException e) {
            countryService.save(leagueDto.getCountry());
            leagueRepository.save(leagueMapper.toEntity(leagueDto));
        }
    }
}
