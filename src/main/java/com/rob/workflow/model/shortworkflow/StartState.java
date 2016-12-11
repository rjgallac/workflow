package com.rob.workflow.model.shortworkflow;

public class StartState implements State {

    private static final String statusReadble = "Start";

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

    public String[] getValidStatuses(){
        return new String[]{"accept", "reject", "withdraw"};
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
