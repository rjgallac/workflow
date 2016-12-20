package com.rob.workflow.controller;

import com.rob.workflow.model.Advert;
import com.rob.workflow.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvertController {

    @Autowired
    AdvertService advertService;

    @RequestMapping(value = "/advert/", method = RequestMethod.GET)
    public List<Advert> getJobAdvert(){
        return advertService.findAll();
    }

}
