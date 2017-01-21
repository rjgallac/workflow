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

    @Autowired
    ReviewServiceImpl reviewService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ReviewerService reviewerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReviewDto> saveReviewer(@RequestBody ReviewDto reviewDto){
        Reviewer reviewer = reviewerService.findOne(reviewDto.getReviewerId());
        Application application = applicationService.getApplication(reviewDto.getApplicationId());
        Review review = new Review(null,application, reviewer, Stage.START, 0);
        Optional<Review> review1 = reviewService.saveReview(review);
        if(review1.isPresent()){
            ReviewDto reviewDto1 = ReviewMapper.toDto(review1.get());
            return new ResponseEntity<ReviewDto>(reviewDto1, null, HttpStatus.OK);
        }else{
            return new ResponseEntity<ReviewDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> getReviews(){
        Optional<List<Review>> reviewers = reviewService.getReviews();
        if(reviewers.isPresent()) {
            return new ResponseEntity<>(reviewers.get().stream().map(ReviewMapper::toDto).collect(toList()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }

}
