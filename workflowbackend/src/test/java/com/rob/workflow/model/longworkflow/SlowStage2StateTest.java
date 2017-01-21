package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SlowStage2StateTest {
    @Test
    public void next() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        workflowState.next();
    }

    @Test
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        workflowState.previous();
    }

    @Test
    public void getStatusReadble() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        assertEquals("Stage 2", workflowState.getState().getStatusReadble());
    }

    @Test
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        workflowState.withdraw();
    }

    @Test
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        workflowState.reject();
    }

    @Test
    public void getValidStatuses() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage2State());
        assertArrayEquals(new String[]{"accept", "reject", "withdraw"},workflowState.getState().getValidStatuses());
    }

}