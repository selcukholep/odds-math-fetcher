package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.CountryDto;
import com.example.oddsmathfetcher.persistance.mapper.CountryMapper;
import com.example.oddsmathfetcher.persistance.repository.CountryRepository;
import com.example.oddsmathfetcher.persistance.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    final CountryRepository countryRepository;
    final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryDto get(int id) {
        return countryMapper.toDto(countryRepository.getById(id));
    }

    @Override
    public void save(CountryDto countryDto) {
        countryRepository.save(countryMapper.toEntity(countryDto));
    }
}
