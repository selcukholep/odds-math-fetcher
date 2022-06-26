package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.MatchDto;
import com.example.oddsmathfetcher.persistance.entity.Match;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "c-match-with-bookmaker-and-odds")
public class MatchMapperWithBookmakerAndOddsImpl extends MatchMapperImpl {

    private BookmakerMatchMapper bookmakerMatchMapper;

    @Autowired
    private void setBookmakerMapper(@Qualifier("c-bookmaker-with-odds") BookmakerMatchMapper bookmakerMatchMapper) {
        this.bookmakerMatchMapper = bookmakerMatchMapper;
    }

    @Override
    public Match toEntity(MatchDto dto) {

        Match match = super.toEntity(dto);

        if (match == null) {
            return null;
        }

        match.setBookmakerMatchList(bookmakerMatchMapper.toEntity(dto.getBookmakerMatchList()));

        return match;
    }

    @Override
    public MatchDto toDto(Match entity) {

        MatchDto matchDto = super.toDto(entity);

        if (matchDto == null) {
            return null;
        }

        matchDto.setBookmakerMatchList(bookmakerMatchMapper.toDto(entity.getBookmakerMatchList()));

        return matchDto;
    }
}
