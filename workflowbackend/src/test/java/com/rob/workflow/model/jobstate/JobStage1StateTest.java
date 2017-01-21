package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        assertArrayEquals(new String[]{"next", "previous"},jobState.getState().getValidStatuses());
    }

}