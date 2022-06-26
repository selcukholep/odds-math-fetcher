package com.example.oddsmathfetcher.domain.event;

import com.example.oddsmathfetcher.domain.dto.MatchDto;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;

public class MatchFetchedEvent extends ApplicationEvent {

    private MatchDto matchDto;

    @Serial
    private static final long serialVersionUID = -4486105446730292982L;

    public MatchFetchedEvent(MatchDto matchDto) {
        super(matchDto);
        this.matchDto = matchDto;
    }

    public MatchDto getMatchDto() {
        return matchDto;
    }
}
