package com.rob.workflow.dto;

public class JobDto {
    private long jobId;
    private String name;

    public JobDto() {
    }

    public JobDto(long jobId, String name) {
        this.jobId = jobId;
        this.name = name;
    }

    public long getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }
}
