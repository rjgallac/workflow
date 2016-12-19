package com.rob.workflow.model.shortworkflow;

public interface State {
    void next(WorkflowState workflowState) throws StateException;
    void previous(WorkflowState workflowState) throws StateException;
    void withdraw(WorkflowState workflowState) throws StateException;
    void reject(WorkflowState workflowState) throws StateException;
    String getStatusReadble();
    String[] getValidStatuses();
}
