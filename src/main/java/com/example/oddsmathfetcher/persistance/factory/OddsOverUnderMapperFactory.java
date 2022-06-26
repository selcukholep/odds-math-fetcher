package com.example.oddsmathfetcher.persistance.factory;

import com.example.oddsmathfetcher.persistance.entity.odds.OddsOverUnder;
import com.example.oddsmathfetcher.persistance.entity.odds.overunder.OddsOverUnder15Full;
import com.example.oddsmathfetcher.persistance.entity.odds.overunder.OddsOverUnder25Full;
import com.example.oddsmathfetcher.persistance.entity.odds.overunder.OddsOverUnder35Full;
import com.example.oddsmathfetcher.persistance.type.OddsType;
import org.springframework.stereotype.Component;

@Component
public class OddsOverUnderMapperFactory {

    public OddsOverUnder getInstance(OddsType oddsType) {

        switch (oddsType) {
            case OVER_UNDER_15_FULL -> {
                return new OddsOverUnder15Full();
            }
            case OVER_UNDER_25_FULL -> {
                return new OddsOverUnder25Full();
            }
            case OVER_UNDER_35_FULL -> {
                return new OddsOverUnder35Full();
            }
        }
        throw new RuntimeException("Type not recognized.");
    }
}
