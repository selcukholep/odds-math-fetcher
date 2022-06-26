package com.example.oddsmathfetcher.client.raw;

import com.example.oddsmathfetcher.util.RawMatchEventDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawMatch {

    String generatedAt;

    @JsonProperty("event")
    RawMatchDetail rawMatchDetail;

    @JsonProperty("data")
    Map<String, RawMatchBookmaker> rawMatchBookmakerMap;

    public String getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(String generatedAt) {
        this.generatedAt = generatedAt;
    }

    public RawMatchDetail getRawMatchDetail() {
        return rawMatchDetail;
    }

    public void setRawMatchDetail(RawMatchDetail rawMatchDetail) {
        this.rawMatchDetail = rawMatchDetail;
    }

    public Map<String, RawMatchBookmaker> getRawMatchBookmakerMap() {
        return rawMatchBookmakerMap;
    }

    @JsonDeserialize(using = RawMatchEventDeserializer.class)
    public void setRawMatchBookmakerMap(Map<String, RawMatchBookmaker> rawMatchBookmakerMap) {
        this.rawMatchBookmakerMap = rawMatchBookmakerMap;
    }
}
