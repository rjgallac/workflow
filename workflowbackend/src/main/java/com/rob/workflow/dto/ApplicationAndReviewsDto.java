package com.rob.workflow.dto;

import java.util.List;

public class ApplicationAndReviewsDto {

    private ApplicationDto applicationDto;
    private List<ReviewDto> reviews;


    public ApplicationAndReviewsDto() {
    }

    public ApplicationAndReviewsDto(ApplicationDto applicationDto, List<ReviewDto> reviews) {
        this.applicationDto = applicationDto;
        this.reviews = reviews;
    }

    public ApplicationDto getApplicationDto() {
        return applicationDto;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }
}
