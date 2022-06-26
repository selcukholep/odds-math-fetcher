package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;
import java.util.Objects;

public class LeagueDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = 3629390240216905840L;

    private int id;
    private String name;
    private CountryDto country;

    public LeagueDto() {
    }

    public LeagueDto(int id) {
        this.id = id;
    }

    public LeagueDto(int id, String name, CountryDto country) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueDto leagueDto = (LeagueDto) o;
        return id == leagueDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}