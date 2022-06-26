package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.BookmakerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmakerMatchRepository extends JpaRepository<BookmakerMatch, String>, JpaSpecificationExecutor<BookmakerMatch> {
}