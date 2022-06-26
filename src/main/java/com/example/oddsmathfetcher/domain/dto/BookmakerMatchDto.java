package com.example.oddsmathfetcher.domain.dto;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;


public class BookmakerMatchDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = -2154258101561412697L;

    private String id;
    private BookmakerDto bookmaker;
    private MatchDto match;
    private OddsType oddsType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastUpdatedDate;
    private boolean active;
    private boolean liveBetting;
    private List<OddsDto> odds;

    public BookmakerMatchDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setBookmaker(BookmakerDto bookmaker) {
        this.bookmaker = bookmaker;
    }

    public BookmakerDto getBookmaker() {
        return this.bookmaker;
    }

    public void setMatch(MatchDto match) {
        this.match = match;
    }

    public MatchDto getMatch() {
        return this.match;
    }

    public void setOddsType(OddsType oddsType) {
        this.oddsType = oddsType;
    }

    public OddsType getOddsType() {
        return this.oddsType;
    }

    public void setLastUpdatedDate(java.time.LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public java.time.LocalDateTime getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setLiveBetting(boolean liveBetting) {
        this.liveBetting = liveBetting;
    }

    public boolean isLiveBetting() {
        return this.liveBetting;
    }

    public void setOdds(List<OddsDto> odds) {
        this.odds = odds;
    }

    public List<OddsDto> getOdds() {
        return this.odds;
    }
}