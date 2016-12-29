package com.rob.workflow.controller;

import com.rob.workflow.dto.ReviewDto;
import com.rob.workflow.dto.ReviewMapper;
import com.rob.workflow.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @RequestMapping(value = "/review/", method = RequestMethod.POST)
    public void saveReviewer(@RequestBody ReviewDto reviewDto){
//        reviewService.saveReviewer(ReviewMapper.toEntity(reviewDto));
    }

}
