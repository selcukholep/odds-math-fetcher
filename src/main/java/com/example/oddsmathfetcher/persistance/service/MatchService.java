package com.example.oddsmathfetcher.persistance.service;

import com.example.oddsmathfetcher.domain.dto.MatchDto;

public interface MatchService {

    MatchDto get(int id);
    void save(MatchDto matchDto);
}
