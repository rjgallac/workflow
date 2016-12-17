package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;

public class JobStartState implements State {

    private static final String statusReadble = "Job Start State";

    @Override
    public void next(JobState jobState) throws StateException {
        jobState.setState(new JobStage1State());
    }

    @Override
    public void previous(JobState jobState) throws StateException {
        throw new StateException();
    }

    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{"next"};
    }
}
