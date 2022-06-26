package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer>, JpaSpecificationExecutor<League> {
}