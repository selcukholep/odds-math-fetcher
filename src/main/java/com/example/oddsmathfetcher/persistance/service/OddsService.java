package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import com.example.oddsmathfetcher.domain.dto.OddsDto;

import java.util.List;

public interface OddsService {

    void save(OddsDto oddsDto);
    void saveAll(OddsType oddsType, List<OddsDto> oddsDtoList);
}
