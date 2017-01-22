package com.rob.workflow.dto;

import java.util.List;

public class JobAndApplicationsDto {
    private JobDto jobDto;
    private List<ApplicationDto> applicationDtoList;

    public JobAndApplicationsDto() {
    }

    public JobAndApplicationsDto(JobDto jobDto, List<ApplicationDto> applicationDtoList) {
        this.jobDto = jobDto;
        this.applicationDtoList = applicationDtoList;
    }

    public JobDto getJobDto() {
        return jobDto;
    }

    public List<ApplicationDto> getApplicationDtoList() {
        return applicationDtoList;
    }
}
