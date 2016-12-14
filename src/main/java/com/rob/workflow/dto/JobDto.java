package com.rob.workflow.dto;

public class JobDto {
    private Long jobId;
    private String name;

    public JobDto() {
    }

    public JobDto(Long jobId, String name) {
        this.jobId = jobId;
        this.name = name;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }
}
