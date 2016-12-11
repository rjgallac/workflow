package com.rob.workflow.model.shortworkflow;

public class SlowStartState implements State {

    private static final String statusReadble = "Slow Start";

    @Override
    public void next(WorkflowState workflowState) {
        workflowState.setState(new Stage1State());
    }

    @Override
    public void previous(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public String getStatusReadble() {
        return statusReadble;
    }

    @Override
    public void withdraw(WorkflowState workflowState) {
        workflowState.setState(new Withdrawn());
    }

    @Override
    public void reject(WorkflowState workflowState) {
        workflowState.setState(new Rejected());
    }
}
