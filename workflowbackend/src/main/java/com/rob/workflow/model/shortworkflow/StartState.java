package com.rob.workflow.model.shortworkflow;

import com.rob.workflow.model.Stage;

import javax.persistence.Enumerated;

public class StartState implements State {

    private static final String statusReadble = "Start";

    @Enumerated
    private Stage stage = Stage.START;

    @Override
    public void next(WorkflowState workflowState) {
        workflowState.setState(new Stage1State());
    }

    @Override
    public void previous(WorkflowState workflowState) throws StateException {
            throw new StateException();
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
