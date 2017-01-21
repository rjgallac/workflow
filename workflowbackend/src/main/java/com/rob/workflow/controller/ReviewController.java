package com.rob.workflow.controller;

import com.rob.workflow.dto.ReviewDto;
import com.rob.workflow.dto.ReviewMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Review;
import com.rob.workflow.model.Reviewer;
import com.rob.workflow.model.Stage;
import com.rob.workflow.service.ApplicationService;
import com.rob.workflow.service.ReviewServiceImpl;
import com.rob.workflow.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    private final ApplicationService applicationService;

    private final ReviewerService reviewerService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService, ApplicationService applicationService, ReviewerService reviewerService) {
        this.reviewService = reviewService;
        this.applicationService = applicationService;
        this.reviewerService = reviewerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReviewDto> saveReviewer(@RequestBody ReviewDto reviewDto){
        Reviewer reviewer = reviewerService.findOne(reviewDto.getReviewerId());
        Application application = applicationService.getApplication(reviewDto.getApplicationId());
        Review review = new Review(null,application, reviewer, Stage.START, 0);
        Optional<Review> review1 = reviewService.saveReview(review);
        if(review1.isPresent()){
            ReviewDto reviewDto1 = ReviewMapper.toDto(review1.get());
            return new ResponseEntity<>(reviewDto1, null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ReviewDto> getReviews(){
        List<Review> reviews = reviewService.getReviews();
        return reviews.stream().map(ReviewMapper::toDto).collect(toList());
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }

}
