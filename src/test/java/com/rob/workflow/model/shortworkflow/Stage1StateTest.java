package com.rob.workflow.model.shortworkflow;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bob on 17/12/16.
 */
public class Stage1StateTest {
    @Test
    public void previous() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage1State());
        workflowState.previous();
    }

    @Test
    public void withdraw() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage1State());
        workflowState.withdraw();
    }

    @Test
    public void reject() throws Exception, StateException {
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new Stage1State());
        workflowState.reject();
    }




}