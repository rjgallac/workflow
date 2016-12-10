package com.rob.workflow.model.shortworkflow;

public class EndState implements State {
    @Override
    public void next(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
//            e.printStackTrace();
            System.out.println("invalid state transistion from end state");
        }
    }

    @Override
    public void previous(WorkflowState workflowState) {
        workflowState.setState(new Stage2State());
    }
}
