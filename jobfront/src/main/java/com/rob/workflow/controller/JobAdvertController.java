package com.rob.workflow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobAdvertController {

    @RequestMapping(value = "/jobadvert/", method = RequestMethod.GET)
    public void getJobAdvert(){

    }

}
