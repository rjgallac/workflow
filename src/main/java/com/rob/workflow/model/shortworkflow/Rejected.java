package com.rob.workflow.model.shortworkflow;

public class Rejected implements State {

    private static final String statusReadble = "Rejected";

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

    public String getStatusReadble() {
        return statusReadble;
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
}
