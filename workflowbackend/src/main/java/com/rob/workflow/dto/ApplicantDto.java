package com.rob.workflow.dto;

public class ApplicantDto {

    private Long applicantId;

    private String name;

    public ApplicantDto() {
    }

    public ApplicantDto(Long applicantId, String name) {
        this.applicantId = applicantId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
