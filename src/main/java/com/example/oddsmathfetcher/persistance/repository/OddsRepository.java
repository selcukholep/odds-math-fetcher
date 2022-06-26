package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.base.Odds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OddsRepository extends JpaRepository<Odds, String>, JpaSpecificationExecutor<Odds> {
}
