package com.rob.workflow.dto;

public class ReviewDto {
    private Long reviewId;

    private Long applicationId;

    private Long reviewerId;

    private int stage;

    private int score;

    private String reviewerName;

    public ReviewDto() {
    }

    public ReviewDto(Long reviewId, Long applicationId, Long reviewerId, int stage, int score, String reviewerName) {
        this.reviewId = reviewId;
        this.applicationId = applicationId;
        this.reviewerId = reviewerId;
        this.stage = stage;
        this.score = score;
        this.reviewerName = reviewerName;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public int getStage() {
        return stage;
    }

    public int getScore() {
        return score;
    }

    public String getReviewerName() {
        return reviewerName;
    }
}
