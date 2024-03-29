package com.rob.workflow.model;

import com.rob.workflow.model.jobstate.JobStartState;
import com.rob.workflow.model.jobstate.JobState;
import com.rob.workflow.model.shortworkflow.StateException;

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

    private String applicationStartState;

    @Transient
    private JobState jobState;

    private String workflowStateString;

    @Transient
    private String updateAction;

    public Job() {
    }

    public Job(Long jobId, String name, String applicationStartState) {
        this.jobId = jobId;
        this.name = name;
        this.jobState = new JobState();
        this.jobState.setState(new JobStartState());
        this.workflowStateString = jobState.getState().getClass().getName();
        this.applicationStartState = applicationStartState;
    }

    public String getName() {
        return name;
    }

    public void setStateString(){
        this.workflowStateString = jobState.getState().getClass().getName();
    }
    public Long getJobId() {
        return jobId;
    }

    public void next(){
        try {
            jobState.next();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }
    public void previous(){
        try {
            jobState.previous();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void restoreState(){
        this.jobState = new JobState();
        jobState.setStateFromDB(workflowStateString);
    }

    public JobState getJobState() {
        return jobState;
    }

    public String getWorkflowStateString() {
        return workflowStateString;
    }

    public void setWorkflowStateString(String workflowStateString) {
        this.workflowStateString = workflowStateString;
    }

    public String getApplicationStartState() {
        return applicationStartState;
    }

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }
}
