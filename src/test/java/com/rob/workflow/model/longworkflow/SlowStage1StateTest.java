package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bob on 17/12/16.
 */
public class SlowStage1StateTest {
    @Test
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        workflowState.previous();
    }

    @Test
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        workflowState.withdraw();
    }

    @Test
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        workflowState.reject();
    }

    @Test
    public void next() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        workflowState.next();
    }

    @Test
    public void getStatusReadble() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        assertEquals("Stage 1 Slow", workflowState.getState().getStatusReadble());
    }

    @Test
    public void getValidStatuses() throws Exception {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStage1State());
        assertEquals(new String[]{"accept", "reject", "withdraw"}, workflowState.getState().getValidStatuses());
    }

}