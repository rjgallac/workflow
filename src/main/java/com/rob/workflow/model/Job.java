package com.rob.workflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private Long jobId;

    private String name;

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
