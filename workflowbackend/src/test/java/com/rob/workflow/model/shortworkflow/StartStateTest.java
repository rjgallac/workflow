package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.*;

public class StartStateTest {
    @Test
    public void getStatusReadble() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new StartState());
        assertEquals("Start", workflowState.getState().getStatusReadble());
    }
    @Test
    public void getWithdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new StartState());
        workflowState.withdraw();
    }
    @Test
    public void getReject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new StartState());
        workflowState.reject();
    }
    @Test(expected = StateException.class)
    public void getPrevious() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new StartState());
        workflowState.previous();
    }

}