package com.example.oddsmathfetcher.persistance.factory;

import com.example.oddsmathfetcher.persistance.entity.odds.OddsFinalTime;
import com.example.oddsmathfetcher.persistance.entity.odds.finaltime.OddsFinalTime1stHalf;
import com.example.oddsmathfetcher.persistance.entity.odds.finaltime.OddsFinalTime2ndHalf;
import com.example.oddsmathfetcher.persistance.entity.odds.finaltime.OddsFinalTimeFull;
import com.example.oddsmathfetcher.persistance.type.OddsType;
import org.springframework.stereotype.Component;

@Component
public class OddsFinalTimeMapperFactory {

    public OddsFinalTime getInstance(OddsType oddsType) {

        switch (oddsType) {
            case FINAL_TIME_FULL -> {
                return new OddsFinalTimeFull();
            }
            case FINAL_TIME_1ST_HALF -> {
                return new OddsFinalTime1stHalf();
            }
            case FINAL_TIME_2ND_HALF -> {
                return new OddsFinalTime2ndHalf();
            }
        }
        throw new RuntimeException("Type not recognized.");
    }
}
