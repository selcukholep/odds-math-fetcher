package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;

public class OddsFinalTimeDto extends OddsDto {

    @Serial
    private static final long serialVersionUID = 5553861690396121749L;

    private double home;
    private double away;
    private double draw;

    public OddsFinalTimeDto() {
    }


    public void setHome(double home) {
        this.home = home;
    }

    public double getHome() {
        return this.home;
    }

    public void setAway(double away) {
        this.away = away;
    }

    public double getAway() {
        return this.away;
    }

    public void setDraw(double draw) {
        this.draw = draw;
    }

    public double getDraw() {
        return this.draw;
    }
}