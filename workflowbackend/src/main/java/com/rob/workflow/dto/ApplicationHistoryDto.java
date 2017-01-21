package com.rob.workflow.dto;

public class ApplicationHistoryDto {
    private String name;
    private String date;

    public ApplicationHistoryDto() {
    }

    public ApplicationHistoryDto(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
