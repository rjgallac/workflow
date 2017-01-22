package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationAndReviewsDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.ReviewDto;
import com.rob.workflow.dto.ReviewMapper;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Review;
import com.rob.workflow.repository.ReviewRepository;
import com.rob.workflow.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicationMapper.toDto;
import static com.rob.workflow.mapper.ApplicationMapper.toEntity;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    private ReviewRepository reviewRepository;

    @Autowired
    public ApplicationController(ApplicationService applicationService, ReviewRepository reviewRepository) {
        this.applicationService = applicationService;
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(toDto(applicationService.createApplication(toEntity(applicationDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public List<ApplicationDto> getApplications(){
        return applicationService.getApplications().stream().map(ApplicationMapper::toDto).collect(Collectors.toList());
    }
    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
    public ApplicationAndReviewsDto getApplication(@PathVariable Long id){
        Application application = applicationService.getApplication(id);
        ApplicationDto applicationDto = ApplicationMapper.toDto(application);
        List<Review> reviewsByApplication = reviewRepository.findReviewsByApplication(application);
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review review : reviewsByApplication) {
            reviewDtos.add(ReviewMapper.toDto(review));
        }
        return new ApplicationAndReviewsDto(applicationDto, reviewDtos);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationDto> updateApplication(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(toDto(applicationService.save(ApplicationMapper.toEntity(applicationDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteOne(id);
    }

}
