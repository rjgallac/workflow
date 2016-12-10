package com.rob.workflow.model.shortworkflow;

public class SlowStartState implements State {
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
}
