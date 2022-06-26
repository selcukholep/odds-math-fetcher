package com.example.oddsmathfetcher.persistance.mapper.impl;

import com.example.oddsmathfetcher.domain.dto.BookmakerDto;
import com.example.oddsmathfetcher.persistance.entity.Bookmaker;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BookmakerMapperImpl implements BookmakerMapper {

    @Override
    public Bookmaker toEntity(BookmakerDto dto) {
        if (dto == null) {
            return null;
        }

        Bookmaker bookmaker = new Bookmaker();

        bookmaker.setId(dto.getId());
        bookmaker.setName(dto.getName());

        return bookmaker;
    }

    @Override
    public BookmakerDto toDto(Bookmaker entity) {
        if (entity == null) {
            return null;
        }

        BookmakerDto bookmakerDto = new BookmakerDto();

        bookmakerDto.setId(entity.getId());
        bookmakerDto.setName(entity.getName());
        bookmakerDto.setCreatedDate(entity.getCreatedDate());

        return bookmakerDto;
    }

    @Override
    public List<Bookmaker> toEntity(List<BookmakerDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Bookmaker> list = new ArrayList<>(dtoList.size());
        for (BookmakerDto bookmakerDto : dtoList) {
            list.add(toEntity(bookmakerDto));
        }

        return list;
    }

    @Override
    public List<BookmakerDto> toDto(List<Bookmaker> entityList) {
        if (entityList == null) {
            return null;
        }

        List<BookmakerDto> list = new ArrayList<>(entityList.size());
        for (Bookmaker bookmaker : entityList) {
            list.add(toDto(bookmaker));
        }

        return list;
    }

    @Override
    public Set<BookmakerDto> toDto(Set<Bookmaker> entityList) {
        if (entityList == null) {
            return null;
        }

        Set<BookmakerDto> set = new HashSet<>();
        for (Bookmaker bookmaker : entityList) {
            set.add(toDto(bookmaker));
        }

        return set;
    }
}
