package com.rob.workflow.model.jobstate;

import com.rob.workflow.model.shortworkflow.StateException;

public class JobState {
    private State state;

    public JobState() {
        this.state = new JobStartState();
    }

    public void next() throws StateException {
            state.next(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void previous() throws StateException{
        state.previous(this);
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
}
