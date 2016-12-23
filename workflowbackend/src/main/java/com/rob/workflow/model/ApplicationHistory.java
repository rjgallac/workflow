package com.rob.workflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class ApplicationHistory{

    @Id
    @GeneratedValue
    private Long applicationHistoryId;

    private String history;

    private LocalDateTime localDateTime;

    public ApplicationHistory() {
    }

    public ApplicationHistory(String history, LocalDateTime localDateTime) {
        this.history = history;
        this.localDateTime = localDateTime;
    }

    public String getHistory() {
        return history;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
