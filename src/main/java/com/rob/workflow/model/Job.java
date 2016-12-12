package com.rob.workflow.model;

import com.rob.workflow.model.shortworkflow.WorkflowState;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private Long jobId;

    private String name;

    @Transient
    private WorkflowState workflowState;

    private String workflowStateString;

    public Job() {
    }

    public Job(Long jobId, String name) {
        this.jobId = jobId;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Long getJobId() {
        return jobId;
    }


}
