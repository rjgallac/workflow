package com.rob.workflow.dto;

import com.rob.workflow.model.Review;

public class ReviewMapper {
    public static void toEntity(ReviewDto reviewDto) {
        //return new Review(reviewDto.getReviewId(), reviewDto.getApplicationId(),);
    }
    public static ReviewDto toDto(Review review) {
        return new ReviewDto(review.getReviewId(), review.getApplication().getApplicationId(), review.getReviewer().getReviewerId(), 0, 0);
    }
}
