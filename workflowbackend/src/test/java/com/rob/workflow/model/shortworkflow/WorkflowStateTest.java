package com.rob.workflow.model.shortworkflow;

import com.rob.workflow.model.Application;
import com.rob.workflow.model.longworkflow.SlowStartState;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkflowStateTest {

    @Test
    public void testWorkFlow(){
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new StartState());
        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.shortworkflow.StartState");
        try {
            workflowState.next();

        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.shortworkflow.Stage1State");
        workflowState.next();
        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.shortworkflow.Stage2State");
        workflowState.next();
        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.shortworkflow.EndState");
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSlowWorkFlow(){
        WorkflowState workflowState = new WorkflowState();
        workflowState.setState(new SlowStartState());
        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.longworkflow.SlowStartState");
        try {
            workflowState.next();
        } catch (StateException e) {
            e.printStackTrace();
        }
        assertEquals(workflowState.getState().getClass().getName(), "com.rob.workflow.model.longworkflow.SlowStage1State");
    }

    @Test
    public void testRestoreWorkFlow(){
        Application application = new Application();
        application.setWorkflowState(new WorkflowState());
        application.getWorkflowState().setStateFromDB("com.rob.workflow.model.shortworkflow.Stage2State");
        assertEquals(application.getWorkflowState().getState().getClass().getName(), "com.rob.workflow.model.shortworkflow.Stage2State");
    }

}