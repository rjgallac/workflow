package com.rob.workflow.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vacancy {

    @Id
    @GeneratedValue
    private Long vacancyId;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Enumerated(EnumType.ORDINAL)
    private Status status;


    @ManyToOne
    private Advert advert;


    public Vacancy() {
    }

    public Long getVacancyId() {
        return vacancyId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Enum getStatus() {
        return status;
    }

    public Advert getAdvert() {
        return advert;
    }
}
