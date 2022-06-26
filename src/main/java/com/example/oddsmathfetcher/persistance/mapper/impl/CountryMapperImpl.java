package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.CountryDto;
import com.example.oddsmathfetcher.persistance.entity.Country;
import com.example.oddsmathfetcher.persistance.mapper.CountryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDto dto) {
        if (dto == null) {
            return null;
        }

        Country country = new Country();

        country.setId(dto.getId());
        country.setName(dto.getName());

        return country;
    }

    @Override
    public CountryDto toDto(Country entity) {
        if (entity == null) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId(entity.getId());
        countryDto.setName(entity.getName());
        countryDto.setCreatedDate(entity.getCreatedDate());

        return countryDto;
    }

    @Override
    public List<Country> toEntity(List<CountryDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Country> list = new ArrayList<>(dtoList.size());
        for (CountryDto countryDto : dtoList) {
            list.add(toEntity(countryDto));
        }

        return list;
    }

    @Override
    public List<CountryDto> toDto(List<Country> entityList) {
        if (entityList == null) {
            return null;
        }

        List<CountryDto> list = new ArrayList<>(entityList.size());
        for (Country country : entityList) {
            list.add(toDto(country));
        }

        return list;
    }

    @Override
    public Set<CountryDto> toDto(Set<Country> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<CountryDto> set = new HashSet<>();
        for (Country country : entityList) {
            set.add(toDto(country));
        }

        return set;
    }
}
