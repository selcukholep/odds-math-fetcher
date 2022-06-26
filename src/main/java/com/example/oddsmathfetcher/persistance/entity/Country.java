package com.example.oddsmathfetcher.persistance.entity;

import com.example.oddsmathfetcher.persistance.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;

@Entity(name = "country")
public class Country extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 3046146497628590790L;

    private int id;
    private String name;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
