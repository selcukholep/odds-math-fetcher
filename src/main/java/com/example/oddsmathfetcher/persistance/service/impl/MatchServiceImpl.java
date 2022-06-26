package com.example.oddsmathfetcher.persistance.service.impl;

import com.example.oddsmathfetcher.domain.dto.MatchDto;
import com.example.oddsmathfetcher.persistance.mapper.MatchMapper;
import com.example.oddsmathfetcher.persistance.repository.MatchRepository;
import com.example.oddsmathfetcher.persistance.service.BookmakerMatchService;
import com.example.oddsmathfetcher.persistance.service.LeagueService;
import com.example.oddsmathfetcher.persistance.service.MatchService;
import com.example.oddsmathfetcher.persistance.service.TeamService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    final MatchRepository matchRepository;
    final MatchMapper matchMapper;

    final TeamService teamService;
    final LeagueService leagueService;
    final BookmakerMatchService bookmakerMatchService;

    public MatchServiceImpl(MatchRepository matchRepository, MatchMapper matchMapper,
                            TeamService teamService, LeagueService leagueService, BookmakerMatchService bookmakerMatchService) {
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.teamService = teamService;
        this.leagueService = leagueService;
        this.bookmakerMatchService = bookmakerMatchService;
    }

    @Override
    public MatchDto get(int id) {
        return matchMapper.toDto(matchRepository.getById(id));
    }

    @Override
    public void save(MatchDto matchDto) {
        try {
            doSave(matchDto);
        } catch (DataIntegrityViolationException e) {
            teamService.save(matchDto.getAwayTeam());
            teamService.save(matchDto.getHomeTeam());
            leagueService.save(matchDto.getLeague());

            doSave(matchDto);
        }
    }

    private void doSave(MatchDto matchDto) {
        matchRepository.save(matchMapper.toEntity(matchDto));

        if (matchDto.getBookmakerMatchList() == null) return;
        bookmakerMatchService.saveAll(matchDto.getBookmakerMatchList());
    }
}
