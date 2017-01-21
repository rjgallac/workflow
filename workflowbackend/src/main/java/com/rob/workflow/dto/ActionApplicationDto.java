package com.rob.workflow.dto;

public class ActionApplicationDto {

    private String updateAction;

    public ActionApplicationDto(String updateAction) {
        this.updateAction = updateAction;
    }

    public ActionApplicationDto() {
    }

    public String getUpdateAction() {
        return updateAction;
    }

}
