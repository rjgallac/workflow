package com.rob.workflow.controller;

import com.rob.workflow.model.Company;
import com.rob.workflow.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {


    @Autowired
    CompanyService companyService;

    @CrossOrigin(origins = "http://127.0.0.1")
    @RequestMapping(value = "/company/", method = RequestMethod.GET)
    public List<Company> getCompanies(){
        return companyService.findAll();
    }
}
