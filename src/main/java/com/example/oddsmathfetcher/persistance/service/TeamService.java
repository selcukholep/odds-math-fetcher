package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.TeamDto;

public interface TeamService {

    TeamDto get(int id);
    void save(TeamDto teamDto);
}
