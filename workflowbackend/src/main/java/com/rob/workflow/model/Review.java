package com.rob.workflow.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    @ManyToOne
    private Application application;

    @ManyToOne
    private Reviewer reviewer;

    @Enumerated
    private Stage stage;

    private int score;
}
