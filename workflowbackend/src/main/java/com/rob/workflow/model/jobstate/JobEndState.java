package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;

public class JobEndState implements State {

    private static final String statusReadble = "Job End State";

    @Override
    public void next(JobState jobState) throws StateException {
        throw new StateException();
    }

    @Override
    public void previous(JobState jobState) throws StateException {
        jobState.setState(new JobStartState());
    }

    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{};
    }
}
