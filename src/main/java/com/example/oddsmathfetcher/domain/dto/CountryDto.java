package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;
import java.util.Objects;

public class CountryDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = 8444238108009543534L;

    private int id;
    private String name;

    public CountryDto() {
    }

    public CountryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}