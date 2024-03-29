package com.rob.workflow.model.shortworkflow;

import com.rob.workflow.model.Stage;

import javax.persistence.Enumerated;

public class Stage1State implements State {

    @Enumerated
    private final Stage stage = Stage.STAGE1;

    private static final String statusReadble = "Stage 1";

    public Stage1State() {
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new StartState());
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

        workflowState.setState(new Stage2State());
    }
    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{"accept", "reject", "withdraw"};
    }
}
