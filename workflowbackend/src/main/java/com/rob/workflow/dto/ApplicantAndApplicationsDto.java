package com.rob.workflow.dto;

import com.rob.workflow.model.Applicant;

import java.util.List;

public class ApplicantAndApplicationsDto {

    private ApplicantDto applicantDto;
    private List<ApplicationDto> applicationDtoList;

    public ApplicantAndApplicationsDto() {
    }

    public ApplicantAndApplicationsDto(ApplicantDto applicantDto, List<ApplicationDto> applicationDtoList) {
        this.applicantDto = applicantDto;
        this.applicationDtoList = applicationDtoList;
    }

    public ApplicantDto getApplicantDto() {
        return applicantDto;
    }

    public List<ApplicationDto> getApplicationDtoList() {
        return applicationDtoList;
    }
}
