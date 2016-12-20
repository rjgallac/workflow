package com.rob.workflow.controller;

import com.rob.workflow.model.Vacancy;
import com.rob.workflow.service.VacancyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacancyController {

    @Autowired
    VacancyServiceImpl vacancyService;

    @RequestMapping(value = "/vacancy/", method = RequestMethod.GET)
    public List<Vacancy> getVacancy(){
        return vacancyService.getVacancies();
    }

}
