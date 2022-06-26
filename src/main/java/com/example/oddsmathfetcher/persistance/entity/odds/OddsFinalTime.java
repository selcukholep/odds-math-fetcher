package com.example.oddsmathfetcher.persistance.entity.odds;

import com.example.oddsmathfetcher.persistance.entity.base.Odds;

import javax.persistence.MappedSuperclass;
import java.io.Serial;

@MappedSuperclass
public class OddsFinalTime extends Odds {

    @Serial
    private static final long serialVersionUID = 1963070876089074942L;

    private double home;
    private double away;
    private double draw;

    public double getHome() {
        return home;
    }

    public double getAway() {
        return away;
    }

    public double getDraw() {
        return draw;
    }

    public void setHome(double home) {
        this.home = home;
    }

    public void setAway(double away) {
        this.away = away;
    }

    public void setDraw(double draw) {
        this.draw = draw;
    }

}
