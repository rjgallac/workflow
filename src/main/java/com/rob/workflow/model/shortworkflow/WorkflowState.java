package com.rob.workflow.model.shortworkflow;

import java.lang.reflect.InvocationTargetException;

public class WorkflowState {
    private State state;

    public WorkflowState() {
        this.state = new StartState();
    }

    public void next() throws StateException {
        try {
            state.next(this);
        } catch (StateException e) {
            throw new StateException();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStateFromDB(String state){
        Object o = null;
        try {
            o = Class.forName(state).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setState((State) o);

    }

    public State getState() {
        return state;
    }

    public void withdraw() throws StateException {
            state.withdraw(this);
    }

    public void reject() throws StateException {
        state.reject(this);
    }

    public void previous() throws StateException{
        state.previous(this);
    }
}
