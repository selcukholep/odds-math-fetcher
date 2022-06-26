package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.odds.finaltime.OddsFinalTimeFull;
import org.springframework.stereotype.Repository;

@Repository("r-odds-final-time")
public interface OddsFinalTimeRepositoryNoBean extends OddsRepositoryNoBean<OddsFinalTimeFull> {
}