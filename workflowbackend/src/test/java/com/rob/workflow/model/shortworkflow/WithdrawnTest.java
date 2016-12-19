package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.*;

public class WithdrawnTest {
    @Test(expected = StateException.class)
    public void next() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Withdrawn());
        workflowState.next();
    }

    @Test(expected = StateException.class)
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Withdrawn());
        workflowState.previous();
    }

    @Test(expected = StateException.class)
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Withdrawn());
        workflowState.withdraw();
    }

    @Test(expected = StateException.class)
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Withdrawn());
        workflowState.reject();
    }

}