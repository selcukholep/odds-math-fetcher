package com.example.oddsmathfetcher.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AbstractDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1889208493765549762L;

    private LocalDateTime createdDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createAt) {
        this.createdDate = createAt;
    }
}