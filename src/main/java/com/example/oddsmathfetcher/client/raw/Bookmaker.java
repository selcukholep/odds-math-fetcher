package com.example.oddsmathfetcher.client.raw;

public enum Bookmaker {
    UNIBET(2),
    BETATHOME(4),
    BETCLIC(5),
    _188BET(6),
    SBOBET(8),
    TITANBET(11),
    _10BET(12),
    DAFABET(13),
    BETWAY(16),
    SPORTINGBET(18),
    BWIN(20),
    _18BET(22),
    NETBET(30),
    BET_52(31),
    _1XBET(32),
    TIPBET(34),
    _888SPORT(35),
    SNAI(36),
    MARATHONBET(38),
    DOUBLEBET(40),
    BETWINNER(41),
    TIPICO(56),
    CAMPOBET(64),
    RABONA(65),
    LIBRABET(66),
    NETBET_IT(73),
    MEGAPARI(74),
    SUPRABETS(80);


    int value;

    Bookmaker(int value) {
        this.value = value;
    }
}
