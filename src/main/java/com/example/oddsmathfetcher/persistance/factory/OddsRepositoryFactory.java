package com.example.oddsmathfetcher.persistance.factory;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import com.example.oddsmathfetcher.persistance.repository.OddsRepositoryNoBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OddsRepositoryFactory {

    final Map<OddsType, OddsRepositoryNoBean> oddsTypeOddsRepositoryMap;

    public OddsRepositoryFactory(Map<String, OddsRepositoryNoBean> oddsRepositoryMap) {
        oddsTypeOddsRepositoryMap = new HashMap<>();

        oddsTypeOddsRepositoryMap.put(OddsType.FINAL_TIME_FULL, oddsRepositoryMap.get("r-odds-final-time"));
        oddsTypeOddsRepositoryMap.put(OddsType.FINAL_TIME_1ST_HALF, oddsRepositoryMap.get("r-odds-final-time"));
        oddsTypeOddsRepositoryMap.put(OddsType.FINAL_TIME_2ND_HALF, oddsRepositoryMap.get("r-odds-final-time"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_15_FULL, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_25_FULL, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_35_FULL, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_15_1ST_HALF, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_25_1ST_HALF, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_35_1ST_HALF, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_15_2ND_HALF, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_25_2ND_HALF, oddsRepositoryMap.get("r-odds-over-under"));
        oddsTypeOddsRepositoryMap.put(OddsType.OVER_UNDER_35_2ND_HALF, oddsRepositoryMap.get("r-odds-over-under"));
    }

    public OddsRepositoryNoBean get(OddsType oddsType) {
        return oddsTypeOddsRepositoryMap.get(oddsType);
    }
}
