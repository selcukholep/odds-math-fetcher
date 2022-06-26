package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.BookmakerMatchDto;

import java.util.List;

public interface BookmakerMatchService {

    BookmakerMatchDto get(String id);
    void save(BookmakerMatchDto bookmakerMatchDto);

    void saveAll(List<BookmakerMatchDto> bookmakerMatchDtoList);
}
