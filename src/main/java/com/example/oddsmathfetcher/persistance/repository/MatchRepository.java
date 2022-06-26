package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>, JpaSpecificationExecutor<Match> {
}