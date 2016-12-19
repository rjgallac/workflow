package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;

public class JobStage1State implements State {

    private static final String statusReadble = "Job Stage 1 State";

    @Override
    public void next(JobState jobState) {
        jobState.setState(new JobStage1State());
    }

    @Override
    public void previous(JobState jobState) throws StateException {
        jobState.setState(new JobStartState());
    }

    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{"next", "previous"};
    }
}
