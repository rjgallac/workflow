package com.rob.workflow.mapper;

import com.rob.workflow.dto.ApplicationHistoryDto;
import com.rob.workflow.model.ApplicationHistory;

public class ApplicationHistoryMapper {

    public static ApplicationHistoryDto toDto(ApplicationHistory applicationHistory){
        ApplicationHistoryDto applicationHistoryDto = new ApplicationHistoryDto(applicationHistory.getHistory(), applicationHistory.getLocalDateTime().toString());
        return applicationHistoryDto;
    }
}
