package com.rob.workflow.service;

import com.rob.workflow.model.Vacancy;
import com.rob.workflow.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService{

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getVacancies() {
        return (List<Vacancy>) vacancyRepository.findAll();
    }
}
