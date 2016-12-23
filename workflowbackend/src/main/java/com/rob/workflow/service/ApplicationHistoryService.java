package com.rob.workflow.service;

import com.rob.workflow.model.ApplicationHistory;
import com.rob.workflow.repository.ApplicationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationHistoryService {

        @Autowired
        private ApplicationHistoryRepository applicationHistoryRepository;

        public ApplicationHistory addHistory(ApplicationHistory applicationHistory){
            return applicationHistoryRepository.save(applicationHistory);
        }
}
