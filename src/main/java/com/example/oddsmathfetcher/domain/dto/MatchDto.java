package com.example.oddsmathfetcher.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

public class MatchDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = -457557480665592960L;

    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private LeagueDto league;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
    private List<BookmakerMatchDto> bookmakerMatchList;

    public MatchDto() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTime(java.time.LocalDateTime time) {
        this.time = time;
    }

    public java.time.LocalDateTime getTime() {
        return this.time;
    }

    public void setLeague(LeagueDto league) {
        this.league = league;
    }

    public LeagueDto getLeague() {
        return this.league;
    }

    public void setHomeTeam(TeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDto getHomeTeam() {
        return this.homeTeam;
    }

    public void setAwayTeam(TeamDto awayTeam) {
        this.awayTeam = awayTeam;
    }

    public TeamDto getAwayTeam() {
        return this.awayTeam;
    }

    public void setBookmakerMatchList(List<BookmakerMatchDto> bookmakerMatchList) {
        this.bookmakerMatchList = bookmakerMatchList;
    }

    public List<BookmakerMatchDto> getBookmakerMatchList() {
        return this.bookmakerMatchList;
    }
}