package com.rob.workflow.service;

import com.rob.workflow.model.Company;
import com.rob.workflow.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();

    }
}
