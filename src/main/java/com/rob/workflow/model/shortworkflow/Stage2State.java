package com.rob.workflow.model.shortworkflow;

public class Stage2State implements State {

    private static final String statusReadble = "Stage 2";

    @Override
    public void next(WorkflowState workflowState) {
        workflowState.setState(new EndState());
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new Stage1State());
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

    public String[] getValidStatuses(){
        return new String[]{"accept", "reject", "withdraw"};
    }
}
