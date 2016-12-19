package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.*;

public class SlowStartState implements State {

    private static final String statusReadble = "Slow Start";

    @Override
    public void next(WorkflowState workflowState) {
        workflowState.setState(new SlowStage1State());
    }

    @Override
    public void previous(WorkflowState workflowState) throws StateException {
        throw new StateException();
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
