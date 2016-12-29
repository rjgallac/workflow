package com.rob.workflow.dto;

import com.rob.workflow.model.Reviewer;

public class ReviewerMapper {
    public static Reviewer toEntity(ReviewerDto reviewerDto) {
        return new Reviewer(reviewerDto.getReviewerId(), reviewerDto.getName());
    }
    public static ReviewerDto toDto(Reviewer reviewer) {
        return new ReviewerDto(reviewer.getReviewerId(), reviewer.getName());
    }
}
