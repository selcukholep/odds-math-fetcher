package com.example.oddsmathfetcher.domain.listener;

import com.example.oddsmathfetcher.domain.event.MatchFetchedEvent;
import com.example.oddsmathfetcher.domain.publisher.MatchPublisher;
import com.example.oddsmathfetcher.persistance.service.MatchService;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MatchFetchedListener implements ApplicationListener<MatchFetchedEvent> {

    final MatchService matchService;
    final MatchPublisher matchPublisher;

    public MatchFetchedListener(MatchService matchService, MatchPublisher matchPublisher) {
        this.matchService = matchService;
        this.matchPublisher = matchPublisher;
    }

    @Async
    @Override
    public void onApplicationEvent(MatchFetchedEvent event) {
        matchService.save(event.getMatchDto());
        matchPublisher.publishSavedMatch(event.getMatchDto());
    }
}
