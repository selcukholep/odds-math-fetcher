package com.example.oddsmathfetcher.persistance.factory;

import com.example.oddsmathfetcher.persistance.type.OddsType;
import com.example.oddsmathfetcher.domain.dto.OddsDto;
import com.example.oddsmathfetcher.persistance.mapper.OddsMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OddsMapperFactory {

    final Map<OddsType, OddsMapper> oddsTypeOddsMapperMap;

    public OddsMapperFactory(Map<String, OddsMapper> oddsMapperMap) {
        this.oddsTypeOddsMapperMap = new HashMap<>();

        oddsTypeOddsMapperMap.put(OddsType.FINAL_TIME_FULL, oddsMapperMap.get("c-odds-final-time"));
        oddsTypeOddsMapperMap.put(OddsType.FINAL_TIME_1ST_HALF, oddsMapperMap.get("c-odds-final-time"));
        oddsTypeOddsMapperMap.put(OddsType.FINAL_TIME_2ND_HALF, oddsMapperMap.get("c-odds-final-time"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_15_FULL, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_25_FULL, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_35_FULL, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_15_1ST_HALF, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_25_1ST_HALF, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_35_1ST_HALF, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_15_2ND_HALF, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_25_2ND_HALF, oddsMapperMap.get("c-odds-over-under"));
        oddsTypeOddsMapperMap.put(OddsType.OVER_UNDER_35_2ND_HALF, oddsMapperMap.get("c-odds-over-under"));

    }

    public OddsMapper getMapper(OddsType oddsType) {
        return oddsTypeOddsMapperMap.get(oddsType);
    }

    public OddsDto newDtoInstance(OddsType oddsType) {
        return oddsTypeOddsMapperMap.get(oddsType).instance();
    }
}
