package com.example.oddsmathfetcher.persistance.entity;

import com.example.oddsmathfetcher.persistance.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serial;

@Entity(name = "league")
public class League extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -7349474985783020831L;

    private int id;
    private String name;

    private Country country;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Country getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
