package com.rob.workflow.model.shortworkflow;

public class Stage2State implements State {
    @Override
    public void next(WorkflowState workflowState) {
        workflowState.setState(new EndState());
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new Stage1State());
    }
}
