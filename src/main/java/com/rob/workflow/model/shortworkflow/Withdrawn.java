package com.rob.workflow.model.shortworkflow;

public class Withdrawn implements State {

    private static final String statusReadble = "Withdrawn";

    @Override
    public void next(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void previous(WorkflowState workflowState) {
        try {
            throw new StateException();
        } catch (StateException e) {
            e.printStackTrace();
        }
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

    public String getStatusReadble() {
        return statusReadble;
    }
}
