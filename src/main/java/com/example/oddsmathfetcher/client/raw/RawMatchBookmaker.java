package com.example.oddsmathfetcher.client.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class RawMatchBookmaker {

    @JsonProperty("x-id")
    public int xId;
    public String updated;
    public Boolean updating;
    public boolean liveBetting;
    public boolean active;

    public Map<String, Object> live;
    public List<Map<String, Object>> history;

    @JsonProperty("x-hash")
    public String xHash;

    public int getxId() {
        return xId;
    }

    public void setxId(int xId) {
        this.xId = xId;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Boolean getUpdating() {
        return updating;
    }

    public void setUpdating(Boolean updating) {
        this.updating = updating;
    }

    public boolean isLiveBetting() {
        return liveBetting;
    }

    public void setLiveBetting(boolean liveBetting) {
        this.liveBetting = liveBetting;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getxHash() {
        return xHash;
    }

    public void setxHash(String xHash) {
        this.xHash = xHash;
    }

    public Map<String, Object> getLive() {
        return live;
    }

    public void setLive(Map<String, Object> live) {
        this.live = live;
    }

    public List<Map<String, Object>> getHistory() {
        return history;
    }

    public void setHistory(List<Map<String, Object>> history) {
        this.history = history;
    }
}
