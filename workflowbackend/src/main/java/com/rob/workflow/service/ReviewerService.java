package com.rob.workflow.service;

import com.rob.workflow.model.Reviewer;

import java.util.Optional;

public interface ReviewerService {
    Optional<Reviewer> saveReviewer(Reviewer reviewer);

    Reviewer findOne(Long reviewerId);

    Optional getReviewers();

    void deleteReview(Long id);
}
