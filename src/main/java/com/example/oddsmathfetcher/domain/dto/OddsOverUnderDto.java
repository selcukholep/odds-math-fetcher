package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;

public class OddsOverUnderDto extends OddsDto {

    @Serial
    private static final long serialVersionUID = -6894352589461271235L;

    private double under;
    private double over;

    public OddsOverUnderDto() {
    }

    public void setUnder(double under) {
        this.under = under;
    }

    public double getUnder() {
        return this.under;
    }

    public void setOver(double over) {
        this.over = over;
    }

    public double getOver() {
        return this.over;
    }
}