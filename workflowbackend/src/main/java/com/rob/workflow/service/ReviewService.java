package com.rob.workflow.service;

import com.rob.workflow.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> saveReview(Review review);
    Optional<List<Review>> getReviews();

    void deleteReview(Long id);
}
