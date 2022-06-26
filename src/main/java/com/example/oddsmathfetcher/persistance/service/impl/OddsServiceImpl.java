package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import com.example.oddsmathfetcher.domain.dto.OddsDto;
import com.example.oddsmathfetcher.persistance.factory.OddsMapperFactory;
import com.example.oddsmathfetcher.persistance.factory.OddsRepositoryFactory;
import com.example.oddsmathfetcher.persistance.repository.OddsRepository;
import com.example.oddsmathfetcher.persistance.service.OddsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsServiceImpl implements OddsService {

    final OddsMapperFactory oddsMapperFactory;
    final OddsRepositoryFactory oddsRepositoryFactory;
    final OddsRepository oddsRepository;

    public OddsServiceImpl(OddsMapperFactory oddsMapperFactory,
                           OddsRepositoryFactory oddsRepositoryFactory,
                           OddsRepository oddsRepository) {
        this.oddsMapperFactory = oddsMapperFactory;
        this.oddsRepositoryFactory = oddsRepositoryFactory;
        this.oddsRepository = oddsRepository;
    }

    @Override
    public void save(OddsDto oddsDto) {
        oddsRepository.save(oddsMapperFactory.getMapper(OddsType.FINAL_TIME_FULL).toEntity(oddsDto));
    }

    @Override
    public void saveAll(OddsType oddsType, List<OddsDto> oddsDtoList) {
        oddsRepository.saveAll(oddsMapperFactory.getMapper(oddsType).toEntity(oddsDtoList));
    }
}
