package com.rob.workflow.service;

import com.rob.workflow.model.Reviewer;
import com.rob.workflow.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewerRepository reviewerRepository;

    public ReviewServiceImpl(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public void saveReviewer(Reviewer reviewer) {
        reviewerRepository.save(reviewer);
    }
}
