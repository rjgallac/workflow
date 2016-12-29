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

    public Review(Long reviewId, Application application, Reviewer reviewer, Stage stage, int score) {
        this.reviewId = reviewId;
        this.application = application;
        this.reviewer = reviewer;
        this.stage = stage;
        this.score = score;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Application getApplication() {
        return application;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public Stage getStage() {
        return stage;
    }

    public int getScore() {
        return score;
    }
}
