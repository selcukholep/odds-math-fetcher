package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.BookmakerDto;

public interface BookmakerService {

    BookmakerDto get(int id);
    void save(BookmakerDto bookmakerDto);
}
