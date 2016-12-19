package com.rob.workflow.dto;

public class JobDto {
    private Long jobId;
    private String name;
    private String[] validStatuses;
    private String status;
    private String updateAction;
    private String applicationStartState;

    public JobDto() {
    }

    public JobDto(Long jobId, String name, String[] validStatuses, String status, String applicationStartState) {
        this.jobId = jobId;
        this.name = name;
        this.validStatuses = validStatuses;
        this.status = status;
        this.applicationStartState = applicationStartState;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }

    public String[] getValidStatuses() {
        return validStatuses;
    }

    public String getStatus() {
        return status;
    }

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }
}
