package com.example.oddsmathfetcher.persistance.entity.odds.overunder;

import com.example.oddsmathfetcher.persistance.entity.odds.OddsOverUnder;

import javax.persistence.Entity;
import java.io.Serial;

@Entity(name = "odds_over_under_15_full")
public class OddsOverUnder15Full extends OddsOverUnder {

    @Serial
    private static final long serialVersionUID = 519095085130410166L;

    private double under;
    private double over;

    public double getUnder() {
        return under;
    }

    public double getOver() {
        return over;
    }

    public void setUnder(double under) {
        this.under = under;
    }

    public void setOver(double over) {
        this.over = over;
    }
}
