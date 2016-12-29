package com.rob.workflow.service;

import com.rob.workflow.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    void saveReview(Review review);
    Optional<List<Review>> getReviews();
}
