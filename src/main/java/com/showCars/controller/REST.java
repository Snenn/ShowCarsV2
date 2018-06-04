package com.showCars.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showCars.services.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class REST {

    @Autowired
    private IAdService adService;

    @RequestMapping(value = "ads", method = RequestMethod.GET)
    public String getAllAds() throws JsonProcessingException {

        List adList = adService.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(adList);
        return json;

    }
}