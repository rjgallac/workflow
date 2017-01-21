package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class EndStateTest {

    @Test(expected = StateException.class)
    public void next() throws StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        workflowState.next();
    }

    @Test(expected = StateException.class)
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        workflowState.previous();
    }

    @Test(expected = StateException.class)
    public void withdraw() throws StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        workflowState.withdraw();

    }

    @Test(expected = StateException.class)
    public void reject() throws StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        workflowState.reject();

    }

    @Test
    public void testState(){
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        assertEquals("End", workflowState.getState().getStatusReadble());
    }

    @Test
    public void testStatues(){
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        String[] expecteds = {"reject", "withdraw", "previous"};
        assertArrayEquals(expecteds, workflowState.getState().getValidStatuses());
    }

}