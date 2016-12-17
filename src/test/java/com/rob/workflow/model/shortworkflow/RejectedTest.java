package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.*;

public class RejectedTest {
    @Test(expected = StateException.class)
    public void next() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Rejected());
        workflowState.reject();
    }

    @Test(expected = StateException.class)
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Rejected());
        workflowState.previous();
    }

    @Test(expected = StateException.class)
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Rejected());
        workflowState.withdraw();
    }

    @Test(expected = StateException.class)
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Rejected());
        workflowState.reject();
    }

}