package com.rob.workflow.dto;

public class ApplicationDto {

    private long applicationId;

    private String name;

    private ApplicantDto applicantDto;

    private JobDto jobDto;

    private String status;

    private String startState;

    public ApplicationDto(Long applicationId, String name, ApplicantDto applicantDto, JobDto jobDto, String status, String startState) {
        this.applicationId = applicationId;
        this.name = name;
        this.applicantDto = applicantDto;
        this.jobDto = jobDto;
        this.status = status;
        this.startState = startState;
    }

    public String getStartState() {
        return startState;
    }

    public ApplicantDto getApplicantDto() {
        return applicantDto;
    }

    public JobDto getJobDto() {
        return jobDto;
    }

    public ApplicationDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public long getApplicationId() {
        return applicationId;
    }
}
