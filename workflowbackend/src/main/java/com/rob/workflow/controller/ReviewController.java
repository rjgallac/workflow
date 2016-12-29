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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ReviewerService reviewerService;


    @RequestMapping(value = "/review/", method = RequestMethod.POST)
    public void saveReviewer(@RequestBody ReviewDto reviewDto){
        Reviewer reviewer = reviewerService.findOne(reviewDto.getReviewerId());
        Application application = applicationService.getApplication(reviewDto.getApplicationId());
        Review review = new Review(null,application, reviewer, Stage.START, 0);
        reviewService.saveReview(review);
    }

    @RequestMapping(value = "/review/", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> getReviews(){
        Optional<List<Review>> reviewers = reviewService.getReviews();
        if(reviewers.isPresent()) {
            return new ResponseEntity<>(reviewers.get().stream().map(ReviewMapper::toDto).collect(toList()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,null, HttpStatus.NOT_FOUND);
        }
    }

}
