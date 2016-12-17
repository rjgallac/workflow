package com.rob.workflow.model.longworkflow;

import com.rob.workflow.model.shortworkflow.*;

public class SlowStage1State implements State {

    private static final String statusReadble = "Stage 1 Slow";

    public SlowStage1State() {
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new SlowStartState());
    }

    @Override
    public void withdraw(WorkflowState workflowState) {
        workflowState.setState(new Withdrawn());
    }

    @Override
    public void reject(WorkflowState workflowState) {
        workflowState.setState(new Rejected());
    }

    @Override
    public void next(WorkflowState workflowState) {

        workflowState.setState(new SlowStage2State());
    }
    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{"accept", "reject", "withdraw"};
    }
}
