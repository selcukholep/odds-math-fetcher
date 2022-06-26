package com.example.oddsmathfetcher.persistance.entity;

import com.example.oddsmathfetcher.persistance.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Match extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -7148819303624144L;

    private int id;
    private LocalDateTime time;
    private League league;
    private Team homeTeam;
    private Team awayTeam;
    private List<BookmakerMatch> bookmakerMatchList;

    @Id
    public int getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public League getLeague() {
        return league;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Team getHomeTeam() {
        return homeTeam;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Team getAwayTeam() {
        return awayTeam;
    }

    @OneToMany(mappedBy = "match")
    public List<BookmakerMatch> getBookmakerMatchList() {
        return bookmakerMatchList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setBookmakerMatchList(List<BookmakerMatch> bookmakerMatchList) {
        this.bookmakerMatchList = bookmakerMatchList;
    }
}
