package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;

public class TeamDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = -2497841759489986449L;

    private int id;
    private String name;
    private CountryDto country;

    public TeamDto() {
    }

    public TeamDto(int id, String name, CountryDto country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public CountryDto getCountry() {
        return this.country;
    }
}