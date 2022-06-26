package com.example.oddsmathfetcher.domain.request;

import com.example.oddsmathfetcher.persistance.type.OddsType;

import java.util.ArrayList;
import java.util.List;

public class FetchFilterRequest {

    private List<OddsType> oddsTypes = new ArrayList<>();

    public List<OddsType> getOddsTypes() {
        return oddsTypes;
    }

    public void setOddsTypes(List<OddsType> oddsTypes) {
        this.oddsTypes = oddsTypes;
    }
}
