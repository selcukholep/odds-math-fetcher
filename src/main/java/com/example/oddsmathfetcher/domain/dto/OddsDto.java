package com.example.oddsmathfetcher.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDateTime;

public class OddsDto extends AbstractDto {

    @Serial
    private static final long serialVersionUID = 3679989060225261431L;

    private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedDate;

    private BookmakerMatchDto bookmakerMatchDto;

    public OddsDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setUpdatedDate(java.time.LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public java.time.LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public BookmakerMatchDto getBookmakerMatchDto() {
        return bookmakerMatchDto;
    }

    public void setBookmakerMatchDto(BookmakerMatchDto bookmakerMatchDto) {
        this.bookmakerMatchDto = bookmakerMatchDto;
    }
}