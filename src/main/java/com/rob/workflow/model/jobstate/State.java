package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;

public interface State {
    void next(JobState jobState) throws StateException;
    void previous(JobState jobState) throws StateException;

    String getStatusReadble();
    String[] getValidStatuses();
}
