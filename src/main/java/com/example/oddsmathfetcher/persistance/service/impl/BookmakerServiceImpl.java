package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.BookmakerDto;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMapper;
import com.example.oddsmathfetcher.persistance.repository.BookmakerRepository;
import com.example.oddsmathfetcher.persistance.service.BookmakerService;
import org.springframework.stereotype.Service;

@Service
public class BookmakerServiceImpl implements BookmakerService {

    final BookmakerRepository bookmakerRepository;
    final BookmakerMapper bookmakerMapper;

    public BookmakerServiceImpl(BookmakerRepository bookmakerRepository, BookmakerMapper bookmakerMapper) {
        this.bookmakerRepository = bookmakerRepository;
        this.bookmakerMapper = bookmakerMapper;
    }

    @Override
    public BookmakerDto get(int id) {
        return bookmakerMapper.toDto(bookmakerRepository.getById(id));
    }

    @Override
    public void save(BookmakerDto bookmakerDto) {
        bookmakerRepository.save(bookmakerMapper.toEntity(bookmakerDto));
    }
}
