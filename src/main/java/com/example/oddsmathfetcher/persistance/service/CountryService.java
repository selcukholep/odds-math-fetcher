package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.CountryDto;

public interface CountryService {

    CountryDto get(int id);
    void save(CountryDto countryDto);
}
