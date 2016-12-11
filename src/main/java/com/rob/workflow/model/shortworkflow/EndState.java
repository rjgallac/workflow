package com.rob.workflow.model.shortworkflow;

public class EndState implements State {

    private static final String statusReadble = "End";

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

    @Override
    public void withdraw(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reject(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{};
    }
}
