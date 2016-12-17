package com.rob.workflow.model;

import com.rob.workflow.model.shortworkflow.*;

import javax.persistence.*;

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

    private String workflowStateString;

    public Application() {
    }

    public Application(Long applicationId, String name, Job job, Applicant applicant, String startState) {
        this.applicationId = applicationId;
        this.name = name;
        this.job = job;
        this.applicant = applicant;
        this.workflowState = new WorkflowState();
        if(startState.equals("slow")){
            this.workflowState.setState(new SlowStartState());
        }else{
            this.workflowState.setState(new StartState());
        }
        this.workflowStateString = workflowState.getState().getClass().getName();
    }

    public void setName(String name) {
        Object o = null;
        try {
            o = Class.forName(workflowStateString).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.workflowState = new WorkflowState();
        this.workflowState.setState((State) o);
        this.name = name;
    }

    public void setWorkflowStateString(String workflowStateString) {
        this.workflowStateString = workflowStateString;
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

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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
}
