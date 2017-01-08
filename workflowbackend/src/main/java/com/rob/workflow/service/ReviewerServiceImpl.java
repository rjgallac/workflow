package com.rob.workflow.service;

import com.rob.workflow.model.Reviewer;
import com.rob.workflow.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepository;

    public ReviewerServiceImpl(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public Optional<Reviewer> saveReviewer(Reviewer reviewer) {
        return Optional.of(reviewerRepository.save(reviewer));
    }

    @Override
    public Reviewer findOne(Long reviewerId) {
        return reviewerRepository.findOne(reviewerId);
    }

    public Optional<List<Reviewer>> getReviewers() {
        return Optional.of((List)reviewerRepository.findAll());
    }
}
