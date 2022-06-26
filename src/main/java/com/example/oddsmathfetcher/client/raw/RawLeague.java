package com.example.oddsmathfetcher.client.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RawLeague {

    public int id;
    public boolean showDate;
    public String name;
    public String label;
    public int country_id;
    public String country_name;
    public boolean international;
    public String country_url;
    public String url;
    @JsonProperty("events")
    public Map<String, RawEvent> events;
    public int index;
    @JsonProperty("x-id")
    public String xId;
    @JsonProperty("x-hash")
    public String xHash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShowDate() {
        return showDate;
    }

    public void setShowDate(boolean showDate) {
        this.showDate = showDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public String getCountry_url() {
        return country_url;
    }

    public void setCountry_url(String country_url) {
        this.country_url = country_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, RawEvent> getEvents() {
        return events;
    }

    public void setEvents(Map<String, RawEvent> events) {
        this.events = events;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getxId() {
        return xId;
    }

    public void setxId(String xId) {
        this.xId = xId;
    }

    public String getxHash() {
        return xHash;
    }

    public void setxHash(String xHash) {
        this.xHash = xHash;
    }
}
