package com.rob.workflow.model;

import com.rob.workflow.model.longworkflow.SlowStartState;
import com.rob.workflow.model.shortworkflow.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "application")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Application {

    @Id
    @GeneratedValue
    private Long applicationId;

    private String name;

    @ManyToOne
    @JoinColumn
    private Job job;

    @ManyToOne
    @JoinColumn
    private Applicant applicant;

    @Transient
    private WorkflowState workflowState;

    @Transient
    private String updateAction;


    private String workflowStateString;

    @OneToMany
    List<ApplicationHistory> applicationHistory;

    public Application() {
    }

    public Application(Long applicationId, String name, Job job, Applicant applicant, String startState) {
        this.applicationId = applicationId;
        this.name = name;
        this.job = job;
        this.applicant = applicant;
        this.workflowState = new WorkflowState();
        this.applicationHistory = new ArrayList<>();
        this.workflowStateString = workflowState.getState().getClass().getName();
    }

    public void addHistory(ApplicationHistory applicationHistory){
        this.applicationHistory.add(applicationHistory);
    }

    public String getName() {
        return name;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public Job getJob() {
        return job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public List<ApplicationHistory> getApplicationHistory() {
        return applicationHistory;
    }

    public void next(){
        try {
            workflowState.next();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void setStateString(){
        this.workflowStateString = workflowState.getState().getClass().getName();
    }

    public String getWorkflowStateString() {
        return workflowStateString;
    }

    public void setWorkflowStateString(String workflowStateString) {
        this.workflowStateString = workflowStateString;
    }

    public WorkflowState getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(WorkflowState workflowState) {
        this.workflowState = workflowState;
    }

    public void withdraw() {
        try {
            this.workflowState.withdraw();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void reject() {
        try {
            this.workflowState.reject();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void restoreState(){
        this.workflowState = new WorkflowState();
        this.getWorkflowState().setStateFromDB(this.getWorkflowStateString());
    }

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }
}
