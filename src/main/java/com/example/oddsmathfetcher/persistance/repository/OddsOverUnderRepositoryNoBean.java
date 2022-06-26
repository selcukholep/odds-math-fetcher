package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.odds.overunder.OddsOverUnder25Full;
import org.springframework.stereotype.Repository;

@Repository("r-odds-over-under")
public interface OddsOverUnderRepositoryNoBean extends OddsRepositoryNoBean<OddsOverUnder25Full> {
}