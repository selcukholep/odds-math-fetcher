package com.example.oddsmathfetcher.persistance.entity;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import com.example.oddsmathfetcher.persistance.entity.base.BaseEntity;
import com.example.oddsmathfetcher.persistance.entity.base.Odds;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BookmakerMatch extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1229659159625750137L;

    private String id;

    private Bookmaker bookmaker;
    private Match match;

    private OddsType oddsType;

    private LocalDateTime lastUpdatedDate;
    private boolean active;
    private boolean liveBetting;

    private List<Odds> odds;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Bookmaker getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public OddsType getOddsType() {
        return oddsType;
    }

    public void setOddsType(OddsType oddsType) {
        this.oddsType = oddsType;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLiveBetting() {
        return liveBetting;
    }

    public void setLiveBetting(boolean liveBetting) {
        this.liveBetting = liveBetting;
    }

    @OneToMany(mappedBy = "bookmakerMatch")
    public List<Odds> getOdds() {
        return odds;
    }

    public void setOdds(List<Odds> odds) {
        this.odds = odds;
    }

}
