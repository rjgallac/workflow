package com.rob.workflow.service;

import com.rob.workflow.model.Application;

import java.util.List;

public interface ApplicationService {
    Application createApplication(Application application);

    List<Application> getApplications();

    Application getApplication(Long id);

    Application save(Application application);

    void deleteOne(Long id);

    Application actionApplication(Application application, String updateAction);
}
