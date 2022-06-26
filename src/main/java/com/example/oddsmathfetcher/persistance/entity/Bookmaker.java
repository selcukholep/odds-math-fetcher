package com.example.oddsmathfetcher.persistance.entity;

import com.example.oddsmathfetcher.persistance.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;

@Entity
public class Bookmaker extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 2271396135764425979L;

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
