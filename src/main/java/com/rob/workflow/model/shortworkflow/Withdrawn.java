package com.rob.workflow.model.shortworkflow;

public class Withdrawn implements State {

    private static final String statusReadble = "Withdrawn";

    @Override
    public void next(WorkflowState workflowState) throws StateException {
        throw new StateException();
    }

    @Override
    public void previous(WorkflowState workflowState) throws StateException {
        throw new StateException();
    }

    @Override
    public void withdraw(WorkflowState workflowState) throws StateException {
        throw new StateException();
    }

    @Override
    public void reject(WorkflowState workflowState) throws StateException {
        throw new StateException();
    }

    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{};
    }
}
