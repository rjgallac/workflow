package com.rob.workflow.service;

import com.rob.workflow.model.Reviewer;

public interface ReviewerService {
    void saveReviewer(Reviewer reviewer);

    Reviewer findOne(Long reviewerId);
}
