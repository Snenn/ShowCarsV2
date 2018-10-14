package com.showCars.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showCars.pojos.User;
import com.showCars.services.IAdService;
import com.showCars.services.IRecordService;
import com.showCars.services.IUserService;
import com.showCars.util.Util;
import org.apache.log4j.Logger;
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
    @Autowired
    private IUserService userService;
    @Autowired
    private IRecordService recordService;
    private Logger logger = Logger.getLogger(HomeController.class);


    @RequestMapping(value = "adsFilters", method = RequestMethod.GET)
    public String getAllAdsFilter(String minYear, String maxYear, String minPrice, String maxPrice) throws JsonProcessingException {
        List adList = null;
        try {
            adList = adService.getAllWithFilters(minYear, maxYear, minPrice, maxPrice);
        } catch (Exception e) {
            logger.error("Exception in get ads, " + e);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(adList);
        return json;

    }

    @RequestMapping(value = "ads", method = RequestMethod.GET)
    public String getAllAds() throws JsonProcessingException {

        List adList = null;
        try {
            adList = adService.getAll();
        } catch (Exception e) {
            logger.error("Exception in get ads, " + e);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(adList);
        return json;

    }

    @RequestMapping(value = "myAds", method = RequestMethod.GET)
    public String getMyAds() throws JsonProcessingException {
        User user = userService.findByLogin(Util.getPrincipal());
        List adList = null;
        try {
            adList = adService.getMyAd(user.getId());
        } catch (Exception e) {
            logger.error("Exception in get ads, " + e);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(adList);
        return json;

    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getUsers() throws JsonProcessingException {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            if (user.getUserRole().getIdRoleUser() == 1) {
                List users = null;
                try {
                    users = userService.getAll();
                    logger.error(users);
                } catch (Exception e) {
                    logger.error("Exception in get users, " + e);
                }
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(users);
                return json;
            }
        }
        return null;

    }

    @RequestMapping(value = "records", method = RequestMethod.GET)
    public String getRecords() throws JsonProcessingException {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            if (user.getUserRole().getIdRoleUser() == 1) {
                List records = null;
                try {
                    records = recordService.getAll();
                    logger.error(records);
                } catch (Exception e) {
                    logger.error("Exception in get records, " + e);
                }
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(records);
                return json;
            }
        }
        return null;

    }


    @RequestMapping(value = "check", method = RequestMethod.GET)
    public String checkLoginPassword(String login, String password) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userService.checkLoginPassword(login, password));
        return json;

    }
}