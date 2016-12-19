package com.rob.workflow.dto;

public class ApplicationDto {

    private long applicationId;

    private String name;

    private ApplicantDto applicantDto;

    private JobDto jobDto;

    private String status;

    private String startState;

    private String updateAction;

    private String[] validStatuses;

    public ApplicationDto(Long applicationId, String name, ApplicantDto applicantDto, JobDto jobDto, String status, String startState, String[] statuses) {
        this.applicationId = applicationId;
        this.name = name;
        this.applicantDto = applicantDto;
        this.jobDto = jobDto;
        this.status = status;
        this.startState = startState;
        this.validStatuses = statuses;
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

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }

    public String[] getValidStatuses() {
        return validStatuses;
    }
}
