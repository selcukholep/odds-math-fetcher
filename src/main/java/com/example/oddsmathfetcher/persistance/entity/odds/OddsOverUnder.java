package com.example.oddsmathfetcher.persistance.entity.odds;

import com.example.oddsmathfetcher.persistance.entity.base.Odds;

import javax.persistence.MappedSuperclass;
import java.io.Serial;

@MappedSuperclass
public class OddsOverUnder extends Odds {

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
