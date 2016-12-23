package com.rob.workflow.model.shortworkflow;

import com.rob.workflow.model.Stage;

import javax.persistence.Enumerated;

public class EndState implements State {

    private static final String statusReadble = "End";

    @Enumerated
    private final Stage stage = Stage.END;

    @Override
    public void next(WorkflowState workflowState) throws StateException {
            System.out.println("invalid state transistion from end state");
            throw new StateException();
//            e.printStackTrace();
    }

    @Override
    public void previous(WorkflowState workflowState) throws StateException {
        System.out.println("invalid state transistion from end state");
        throw new StateException();
    }

    @Override
    public void withdraw(WorkflowState workflowState) throws StateException {
        System.out.println("invalid state transistion from end state");
        throw new StateException();
    }

    @Override
    public void reject(WorkflowState workflowState) throws StateException {
        System.out.println("invalid state transistion from end state");
        throw new StateException();
    }

    @Override
    public String getStatusReadble() {
        return statusReadble;
    }

    public String[] getValidStatuses(){
        return new String[]{"reject", "withdraw", "previous"};
    }
}
