package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobStartStateTest {
    @Test
    public void getStatusReadble() throws Exception {
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        assertEquals("Job Start State",jobState.getState().getStatusReadble());
    }

    @Test(expected = StateException.class)
    public void testPrevious() throws StateException {
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        jobState.previous();
    }

    @Test
    public void getValidStatuses() throws Exception {
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        assertEquals(new String[]{"next"}, jobState.getState().getValidStatuses());
    }

    @Test
    public void getReadable(){
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        assertEquals("Job Start State", jobState.getState().getStatusReadble());
    }


}