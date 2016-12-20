package com.rob.workflow.service;

import com.rob.workflow.model.Advert;
import com.rob.workflow.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertService {

    @Autowired
    AdvertRepository advertRepository;


    public List<Advert> findAll() {
        return (List<Advert>) advertRepository.findAll();
    }
}
