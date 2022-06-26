package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.BookmakerMatchDto;
import com.example.oddsmathfetcher.persistance.entity.BookmakerMatch;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMapper;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import com.example.oddsmathfetcher.persistance.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @apiNote Bookmakers of match without odds.
 */
@Primary
@Component
public class BookmakerMatchMapperImpl implements BookmakerMatchMapper {

    private BookmakerMapper bookmakerMapper;
    private MatchMapper matchMapper;

    @Autowired
    private void setBookmakerMapper(BookmakerMapper bookmakerMapper) {
        this.bookmakerMapper = bookmakerMapper;
    }

    @Autowired
    private void setMatchMapper(MatchMapper matchMapper) {
        this.matchMapper = matchMapper;
    }

    @Override
    public BookmakerMatch toEntity(BookmakerMatchDto dto) {
        if (dto == null) {
            return null;
        }

        BookmakerMatch bookmakerMatch = new BookmakerMatch();

        bookmakerMatch.setId(dto.getId());
        bookmakerMatch.setBookmaker(bookmakerMapper.toEntity(dto.getBookmaker()));
        bookmakerMatch.setMatch(matchMapper.toEntity(dto.getMatch()));
        bookmakerMatch.setOddsType(dto.getOddsType());
        bookmakerMatch.setLastUpdatedDate(dto.getLastUpdatedDate());
        bookmakerMatch.setActive(dto.isActive());
        bookmakerMatch.setLiveBetting(dto.isLiveBetting());

        return bookmakerMatch;
    }

    @Override
    public BookmakerMatchDto toDto(BookmakerMatch entity) {
        if (entity == null) {
            return null;
        }

        BookmakerMatchDto bookmakerMatchDto = new BookmakerMatchDto();

        bookmakerMatchDto.setCreatedDate(entity.getCreatedDate());
        bookmakerMatchDto.setId(entity.getId());
        bookmakerMatchDto.setBookmaker(bookmakerMapper.toDto(entity.getBookmaker()));
        bookmakerMatchDto.setMatch(matchMapper.toDto(entity.getMatch()));
        bookmakerMatchDto.setOddsType(entity.getOddsType());
        bookmakerMatchDto.setLastUpdatedDate(entity.getLastUpdatedDate());
        bookmakerMatchDto.setActive(entity.isActive());
        bookmakerMatchDto.setLiveBetting(entity.isLiveBetting());

        return bookmakerMatchDto;
    }

    @Override
    public List<BookmakerMatch> toEntity(List<BookmakerMatchDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<BookmakerMatch> list = new ArrayList<>(dtoList.size());
        for (BookmakerMatchDto bookmakerMatchDto : dtoList) {
            list.add(toEntity(bookmakerMatchDto));
        }

        return list;
    }

    @Override
    public List<BookmakerMatchDto> toDto(List<BookmakerMatch> entityList) {
        if (entityList == null) {
            return null;
        }

        List<BookmakerMatchDto> list = new ArrayList<>(entityList.size());
        for (BookmakerMatch bookmakerMatch : entityList) {
            list.add(toDto(bookmakerMatch));
        }

        return list;
    }

    @Override
    public Set<BookmakerMatchDto> toDto(Set<BookmakerMatch> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<BookmakerMatchDto> set = new HashSet<>();
        for (BookmakerMatch bookmakerMatch : entityList) {
            set.add(toDto(bookmakerMatch));
        }

        return set;
    }
}
