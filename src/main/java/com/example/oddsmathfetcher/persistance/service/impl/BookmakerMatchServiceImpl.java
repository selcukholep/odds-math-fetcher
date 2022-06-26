package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.BookmakerMatchDto;
import com.example.oddsmathfetcher.persistance.entity.BookmakerMatch;
import com.example.oddsmathfetcher.persistance.mapper.BookmakerMatchMapper;
import com.example.oddsmathfetcher.persistance.repository.BookmakerMatchRepository;
import com.example.oddsmathfetcher.persistance.service.BookmakerMatchService;
import com.example.oddsmathfetcher.persistance.service.BookmakerService;
import com.example.oddsmathfetcher.persistance.service.OddsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmakerMatchServiceImpl implements BookmakerMatchService {

    final BookmakerMatchRepository bookmakerMatchRepository;
    final BookmakerMatchMapper bookmakerMatchMapper;

    final OddsService oddsService;
    final BookmakerService bookmakerService;

    public BookmakerMatchServiceImpl(BookmakerMatchRepository bookmakerMatchRepository,
                                     BookmakerMatchMapper bookmakerMatchMapper,
                                     OddsService oddsService,
                                     BookmakerService bookmakerService) {
        this.bookmakerMatchRepository = bookmakerMatchRepository;
        this.bookmakerMatchMapper = bookmakerMatchMapper;
        this.oddsService = oddsService;
        this.bookmakerService = bookmakerService;
    }

    @Override
    public BookmakerMatchDto get(String id) {
        return bookmakerMatchMapper.toDto(bookmakerMatchRepository.getById(id));
    }

    @Override
    public void save(BookmakerMatchDto bookmakerMatchDto) {
        try {
            doSave(bookmakerMatchDto);
        } catch (Exception e) {
            bookmakerService.save(bookmakerMatchDto.getBookmaker());
            doSave(bookmakerMatchDto);
        }
    }

    @Override
    public void saveAll(List<BookmakerMatchDto> bookmakerMatchDtoList) {
        try {
            doSaveAll(bookmakerMatchDtoList);
        } catch (Exception e) {
            bookmakerMatchDtoList.forEach(this::save);
        }
    }

    private void doSave(BookmakerMatchDto bookmakerMatchDto) {
        BookmakerMatch bookmakerMatch = bookmakerMatchRepository.save(bookmakerMatchMapper.toEntity(bookmakerMatchDto));
        bookmakerMatchDto.setId(bookmakerMatch.getId());
        bookmakerMatchDto.getOdds().forEach(oddsDto -> {
            oddsDto.setBookmakerMatchDto(bookmakerMatchDto);
        });
        oddsService.saveAll(bookmakerMatchDto.getOddsType(), bookmakerMatchDto.getOdds());
    }

    private void doSaveAll(List<BookmakerMatchDto> bookmakerMatchDtoList) {
        bookmakerMatchRepository.saveAll(bookmakerMatchMapper.toEntity(bookmakerMatchDtoList));
        bookmakerMatchDtoList.forEach(bookmakerMatch -> {
            oddsService.saveAll(bookmakerMatch.getOddsType(), bookmakerMatch.getOdds().stream().peek(oddsDto ->
                    oddsDto.setBookmakerMatchDto(bookmakerMatch)).collect(Collectors.toList()));
        });
    }
}
