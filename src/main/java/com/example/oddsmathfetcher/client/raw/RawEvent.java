package com.example.oddsmathfetcher.client.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RawEvent {

    public int id;
    public String time;
    public String url;
    public int league_id;
    public int hometeam_id;
    public int awayteam_id;
    public String hometeam_name;
    public String awayteam_name;
    public int hometeam_country_id;
    public int awayteam_country_id;
    public String hometeam_country;
    public String awayteam_country;
    public int bookmaker_count;
    public int max_1;
    public int max_X;
    public double max_2;
    public double margin;
    @JsonProperty("x-id")
    public int xId;
    @JsonProperty("x-hash")
    public String xHash;

    @JsonProperty("livescore")
    public RawLiveScore rawLiveScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public int getHometeam_id() {
        return hometeam_id;
    }

    public void setHometeam_id(int hometeam_id) {
        this.hometeam_id = hometeam_id;
    }

    public int getAwayteam_id() {
        return awayteam_id;
    }

    public void setAwayteam_id(int awayteam_id) {
        this.awayteam_id = awayteam_id;
    }

    public String getHometeam_name() {
        return hometeam_name;
    }

    public void setHometeam_name(String hometeam_name) {
        this.hometeam_name = hometeam_name;
    }

    public String getAwayteam_name() {
        return awayteam_name;
    }

    public void setAwayteam_name(String awayteam_name) {
        this.awayteam_name = awayteam_name;
    }

    public int getHometeam_country_id() {
        return hometeam_country_id;
    }

    public void setHometeam_country_id(int hometeam_country_id) {
        this.hometeam_country_id = hometeam_country_id;
    }

    public int getAwayteam_country_id() {
        return awayteam_country_id;
    }

    public void setAwayteam_country_id(int awayteam_country_id) {
        this.awayteam_country_id = awayteam_country_id;
    }

    public String getHometeam_country() {
        return hometeam_country;
    }

    public void setHometeam_country(String hometeam_country) {
        this.hometeam_country = hometeam_country;
    }

    public String getAwayteam_country() {
        return awayteam_country;
    }

    public void setAwayteam_country(String awayteam_country) {
        this.awayteam_country = awayteam_country;
    }

    public int getBookmaker_count() {
        return bookmaker_count;
    }

    public void setBookmaker_count(int bookmaker_count) {
        this.bookmaker_count = bookmaker_count;
    }

    public int getMax_1() {
        return max_1;
    }

    public void setMax_1(int max_1) {
        this.max_1 = max_1;
    }

    public int getMax_X() {
        return max_X;
    }

    public void setMax_X(int max_X) {
        this.max_X = max_X;
    }

    public double getMax_2() {
        return max_2;
    }

    public void setMax_2(double max_2) {
        this.max_2 = max_2;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public int getxId() {
        return xId;
    }

    public void setxId(int xId) {
        this.xId = xId;
    }

    public String getxHash() {
        return xHash;
    }

    public void setxHash(String xHash) {
        this.xHash = xHash;
    }

    public RawLiveScore getRawLiveScore() {
        return rawLiveScore;
    }

    public void setRawLiveScore(RawLiveScore rawLiveScore) {
        this.rawLiveScore = rawLiveScore;
    }
}
