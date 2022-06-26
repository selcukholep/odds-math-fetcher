package com.example.oddsmathfetcher.client.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RawEventsByDay {

    @JsonProperty("odds-time")
    String oddsTime;
    @JsonProperty("grouped-by")
    String groupedBy;
    @JsonProperty("data")
    Map<String, RawLeague> leagueMap;

    public String getOddsTime() {
        return oddsTime;
    }

    public void setOddsTime(String oddsTime) {
        this.oddsTime = oddsTime;
    }

    public String getGroupedBy() {
        return groupedBy;
    }

    public void setGroupedBy(String groupedBy) {
        this.groupedBy = groupedBy;
    }

    public Map<String, RawLeague> getLeagueMap() {
        return leagueMap;
    }

    public void setLeagueMap(Map<String, RawLeague> leagueMap) {
        this.leagueMap = leagueMap;
    }
}
