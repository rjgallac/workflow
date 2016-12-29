package com.rob.workflow.dto;

public class ReviewerDto {

    private Long reviewerId;

    private String name;

    public ReviewerDto() {
    }

    public ReviewerDto(Long reviewerId, String name) {
        this.reviewerId = reviewerId;
        this.name = name;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public String getName() {
        return name;
    }
}
