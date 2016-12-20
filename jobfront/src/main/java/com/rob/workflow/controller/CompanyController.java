package com.rob.workflow.controller;

import com.rob.workflow.model.Company;
import com.rob.workflow.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {


    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/company/", method = RequestMethod.GET)
    public List<Company> getCompanies(){
        return companyService.findAll();
    }
}
