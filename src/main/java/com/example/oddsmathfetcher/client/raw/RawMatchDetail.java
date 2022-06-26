package com.example.oddsmathfetcher.client.raw;

public class RawMatchDetail {

    String time;

    RawTeamInfo hometeam;
    RawTeamInfo awayteam;

    String url;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public RawTeamInfo getHometeam() {
        return hometeam;
    }

    public void setHometeam(RawTeamInfo hometeam) {
        this.hometeam = hometeam;
    }

    public RawTeamInfo getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(RawTeamInfo awayteam) {
        this.awayteam = awayteam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
