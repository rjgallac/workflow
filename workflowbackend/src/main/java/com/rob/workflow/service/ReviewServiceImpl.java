package com.rob.workflow.service;

import com.rob.workflow.model.Review;
import com.rob.workflow.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> saveReview(Review review) {
        return Optional.of(reviewRepository.save(review));
    }

    public List getReviews() {
        return (List)reviewRepository.findAll();
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(id);
    }
}
