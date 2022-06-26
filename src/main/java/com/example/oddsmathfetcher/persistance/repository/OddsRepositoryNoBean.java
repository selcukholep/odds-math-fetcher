package com.example.oddsmathfetcher.persistance.repository;

import com.example.oddsmathfetcher.persistance.entity.base.Odds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OddsRepositoryNoBean<T extends Odds> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
}
