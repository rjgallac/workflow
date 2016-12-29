package com.rob.workflow.service;

import com.rob.workflow.model.Reviewer;

import java.util.List;
import java.util.Optional;

public interface ReviewerService {
    void saveReviewer(Reviewer reviewer);

    Reviewer findOne(Long reviewerId);

    Optional<List<Reviewer>> getReviewers();
}
