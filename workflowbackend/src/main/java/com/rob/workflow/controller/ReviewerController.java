package com.rob.workflow.controller;

import com.rob.workflow.dto.ReviewerDto;
import com.rob.workflow.dto.ReviewerMapper;
import com.rob.workflow.service.ReviewerServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReviewerController {

    private ReviewerServiceImpl reviewerService;


    public ReviewerController(ReviewerServiceImpl reviewerService) {
        this.reviewerService = reviewerService;
    }


    @RequestMapping(value = "/reviewer/", method = RequestMethod.POST)
    public void saveReviewer(@RequestBody ReviewerDto reviewerDto){
        reviewerService.saveReviewer(ReviewerMapper.toEntity(reviewerDto));
    }


}
