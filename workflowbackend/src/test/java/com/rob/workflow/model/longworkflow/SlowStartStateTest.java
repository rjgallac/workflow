package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SlowStartStateTest {
    @Test
    public void next() throws Exception {

    }

    @Test(expected = StateException.class)
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        workflowState.previous();
    }

    @Test
    public void getStatusReadble() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        assertEquals("Slow Start", workflowState.getState().getStatusReadble());
    }

    @Test
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        workflowState.withdraw();
        assertEquals("Withdrawn", workflowState.getState().getStatusReadble());
    }

    @Test
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        workflowState.reject();
        assertEquals("Rejected", workflowState.getState().getStatusReadble());
    }

    @Test
    public void getValidStatuses() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        assertArrayEquals(new String[]{"accept", "reject", "withdraw"}, workflowState.getState().getValidStatuses());
    }

}