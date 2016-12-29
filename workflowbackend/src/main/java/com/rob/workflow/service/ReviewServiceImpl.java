package com.rob.workflow.service;

import com.rob.workflow.model.Review;
import com.rob.workflow.model.Reviewer;
import com.rob.workflow.repository.ReviewRepository;
import com.rob.workflow.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public Optional<List<Review>> getReviews() {
        return Optional.of((List)reviewRepository.findAll());
    }
}
