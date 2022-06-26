package com.example.oddsmathfetcher.persistance.entity.base;

import com.example.oddsmathfetcher.persistance.entity.BookmakerMatch;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "odds")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Odds extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -6748449720469404875L;

    private String id;
    private LocalDateTime updatedDate;
    private BookmakerMatch bookmakerMatch;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public BookmakerMatch getBookmakerMatch() {
        return bookmakerMatch;
    }

    public void setBookmakerMatch(BookmakerMatch bookmakerMatch) {
        this.bookmakerMatch = bookmakerMatch;
    }
}
