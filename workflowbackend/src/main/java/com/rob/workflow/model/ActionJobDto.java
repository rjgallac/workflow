package com.rob.workflow.model;

public class ActionJobDto {

    private String updateAction;

    public ActionJobDto() {
    }

    public ActionJobDto(String updateAction) {
        this.updateAction = updateAction;
    }

    public String getUpdateAction() {
        return updateAction;
    }
}
