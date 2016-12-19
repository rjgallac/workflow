package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.longworkflow.SlowStage1State;
import com.rob.workflow.model.shortworkflow.StateException;
import com.rob.workflow.model.shortworkflow.WorkflowState;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobStage1StateTest {
    @Test
    public void next() throws Exception, StateException {
        JobState jobState = new JobState();
        jobState.setState(new JobStage1State());
        jobState.next();
    }

    @Test
    public void previous() throws Exception, StateException {
        JobState jobState = new JobState();
        jobState.setState(new JobStage1State());
        jobState.previous();
    }

    @Test
    public void getStatusReadble() throws Exception {
        JobState jobState = new JobState();
        jobState.setState(new JobStage1State());
        assertEquals("Job Stage 1 State",jobState.getState().getStatusReadble());

    }

    @Test
    public void getValidStatuses() throws Exception {
        JobState jobState = new JobState();
        jobState.setState(new JobStage1State());
        assertEquals(new String[]{"next", "previous"},jobState.getState().getValidStatuses());
    }

}