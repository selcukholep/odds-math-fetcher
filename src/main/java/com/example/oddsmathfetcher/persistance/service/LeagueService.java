package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.LeagueDto;

public interface LeagueService {

    LeagueDto get(int id);
    void save(LeagueDto leagueDto);
}
