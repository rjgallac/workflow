package com.rob.workflow.controller;

import com.rob.workflow.dto.ReviewerDto;
import com.rob.workflow.dto.ReviewerMapper;
import com.rob.workflow.model.Reviewer;
import com.rob.workflow.service.ReviewerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


@RestController
@RequestMapping(value = "/reviewer/")
public class ReviewerController {

    private ReviewerServiceImpl reviewerService;


    public ReviewerController(ReviewerServiceImpl reviewerService) {
        this.reviewerService = reviewerService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReviewerDto> saveReviewer(@RequestBody ReviewerDto reviewerDto){
        Optional<Reviewer> reviewer = reviewerService.saveReviewer(ReviewerMapper.toEntity(reviewerDto));
        if(reviewer.isPresent()){
            return new ResponseEntity<ReviewerDto>(ReviewerMapper.toDto(reviewer.get()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<ReviewerDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ReviewerDto>> getJobs(){
        Optional<List<Reviewer>> reviewers = reviewerService.getReviewers();
        if(reviewers.isPresent()) {
            return new ResponseEntity<>(reviewers.get().stream().map(ReviewerMapper::toDto).collect(toList()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable Long id){
        reviewerService.deleteReview(id);
    }

}
