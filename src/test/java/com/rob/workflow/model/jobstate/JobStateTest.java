package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobStateTest {

    @Test
    public void next() throws Exception, StateException {
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        jobState.next();
        jobState.previous();
    }

    @Test(expected=StateException.class)
    public void previous() throws Exception, StateException {
        JobState jobState = new JobState();
        jobState.setState(new JobStartState());
        jobState.previous();
    }

}