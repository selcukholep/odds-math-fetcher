package com.example.oddsmathfetcher.persistance.type;

import java.util.stream.Stream;

public enum OddsType {

    /* 1, 2, X */
    FINAL_TIME_FULL(0),
    FINAL_TIME_1ST_HALF(32),
    FINAL_TIME_2ND_HALF(64),

    /* 12, 1X, 2X */
    DOUBLE_CHANCE_FULL(1),
    DOUBLE_CHANCE_1ST_HALF(33),
    DOUBLE_CHANCE_2ND_HALF(65),

    /* 1, 2 */
    DRAW_NO_BET_FULL(2),
    DRAW_NO_BET_1ST_HALF(34),
    DRAW_NO_BET_2ND_HALF(66),

    /* 1, 2, amount_1, amount_2 */
    ASIAN_HANDICAP_PLUS_05_FULL(3),
    ASIAN_HANDICAP_PLUS_05_1ST_HALF(35),
    ASIAN_HANDICAP_PLUS_05_2ND_HALF(67),

    ASIAN_HANDICAP_0_FULL(4),
    ASIAN_HANDICAP_0_1ST_HALF(36),
    ASIAN_HANDICAP_0_2ND_HALF(68),

    ASIAN_HANDICAP_MINUS_05_FULL(5),
    ASIAN_HANDICAP_MINUS_05_1ST_HALF(37),
    ASIAN_HANDICAP_MINUS_05_2ND_HALF(69),

    /* O, U */
    OVER_UNDER_25_FULL(6),
    OVER_UNDER_25_1ST_HALF(38),
    OVER_UNDER_25_2ND_HALF(70),

    OVER_UNDER_15_FULL(7),
    OVER_UNDER_15_1ST_HALF(39),
    OVER_UNDER_15_2ND_HALF(71),

    OVER_UNDER_35_FULL(8),
    OVER_UNDER_35_1ST_HALF(40),
    OVER_UNDER_35_2ND_HALF(72);

    int value;

    public int value() {
        return value;
    }

    OddsType(int value) {
        this.value = value;
    }

    public static OddsType of(int type) {
        return Stream.of(OddsType.values())
                .filter(t -> t.value() == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
