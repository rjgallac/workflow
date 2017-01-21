package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllStatesTest {

    @Test
    public void allLongStates() throws StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        assertEquals("Slow Start", workflowState.getState().getStatusReadble());
        workflowState.next();
        assertEquals("Stage 1 Slow", workflowState.getState().getStatusReadble());
        workflowState.next();
        assertEquals("Stage 2", workflowState.getState().getStatusReadble());
        workflowState.next();
        assertEquals("End", workflowState.getState().getStatusReadble());
    }
}
