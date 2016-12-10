package com.rob.workflow.model.shortworkflow;

public interface State {
    void next(WorkflowState workflowState);
    void previous(WorkflowState workflowState);
}
