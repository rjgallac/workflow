package com.rob.workflow.model.shortworkflow;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EndStateTest {

    @Test(expected = StateException.class)
    public void next() throws StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new EndState());
        workflowState.next();
    }

    @Test
    public void previous() throws Exception {

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

}