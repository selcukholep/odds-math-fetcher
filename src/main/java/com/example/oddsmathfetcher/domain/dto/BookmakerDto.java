package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;

public class BookmakerDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = 594477603721878890L;

    private int id;
    private String name;

    public BookmakerDto() {
    }

    public BookmakerDto(int id, String name) {
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
}