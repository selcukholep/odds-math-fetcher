package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.BookmakerMatchDto;
import com.example.oddsmathfetcher.persistance.entity.BookmakerMatch;
import com.example.oddsmathfetcher.persistance.factory.OddsMapperFactory;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c-bookmaker-with-odds")
public class BookmakerWithOddsMapper extends BookmakerMatchMapperImpl implements BookmakerMatchMapper {

    private OddsMapperFactory oddsMapperFactory;

    @Autowired
    private void setOddsMapperFactory(OddsMapperFactory oddsMapperFactory) {
        this.oddsMapperFactory = oddsMapperFactory;
    }

    @Override
    public BookmakerMatch toEntity(BookmakerMatchDto dto) {
        BookmakerMatch bookmakerMatch = super.toEntity(dto);

        if (bookmakerMatch == null) {
            return null;
        }

        bookmakerMatch.setOdds(oddsMapperFactory.getMapper(dto.getOddsType()).toEntity(dto.getOdds()));

        return bookmakerMatch;
    }

    @Override
    public BookmakerMatchDto toDto(BookmakerMatch entity) {
        BookmakerMatchDto bookmakerMatchDto = super.toDto(entity);

        if (bookmakerMatchDto == null) {
            return null;
        }

        bookmakerMatchDto.setOdds(oddsMapperFactory.getMapper(entity.getOddsType()).toDto(entity.getOdds()));

        return bookmakerMatchDto;
    }
}
