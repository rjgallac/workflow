package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bob on 17/12/16.
 */
public class Stage2StateTest {
    @Test
    public void next() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        workflowState.next();
        assertEquals("End", workflowState.getState().getStatusReadble());
    }

    @Test
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        workflowState.previous();
    }

    @Test
    public void getStatusReadble() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        assertEquals("Stage 2", workflowState.getState().getStatusReadble());
    }

    @Test
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        workflowState.withdraw();
        assertEquals("Withdrawn", workflowState.getState().getStatusReadble());

    }

    @Test
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        workflowState.reject();
        assertEquals("Rejected", workflowState.getState().getStatusReadble());

    }

    @Test
    public void getValidStatuses() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage2State());
        String[] expecteds = {"accept", "reject", "withdraw"};
        assertEquals(expecteds, workflowState.getState().getValidStatuses());
    }

}