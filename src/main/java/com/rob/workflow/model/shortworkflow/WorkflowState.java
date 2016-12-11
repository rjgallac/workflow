package com.rob.workflow.model.shortworkflow;

import java.lang.reflect.InvocationTargetException;

public class WorkflowState {
    private State state;

    public WorkflowState() {
        this.state = new StartState();
    }

    public void next(){
        state.next(this);
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

    public void withdraw() {
        state.withdraw(this);
    }

    public void reject() {
        state.reject(this);
    }
}
