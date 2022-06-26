package com.example.oddsmathfetcher.domain.publisher;

import com.example.oddsmathfetcher.domain.dto.MatchDto;
import com.example.oddsmathfetcher.domain.event.MatchFetchedEvent;
import com.example.oddsmathfetcher.domain.event.MatchSavedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MatchPublisher {

    private final ApplicationEventPublisher publisher;

    public MatchPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishFetchedMatch(final MatchDto matchDto) {
        publisher.publishEvent(new MatchFetchedEvent(matchDto));
    }

    public void publishSavedMatch(final MatchDto matchDto) {
        publisher.publishEvent(new MatchSavedEvent(matchDto));
    }
}
