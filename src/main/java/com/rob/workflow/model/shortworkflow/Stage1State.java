package com.rob.workflow.model.shortworkflow;

public class Stage1State implements State {

    public Stage1State() {
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new StartState());
    }

    @Override
    public void next(WorkflowState workflowState) {

        workflowState.setState(new Stage2State());
    }
}
