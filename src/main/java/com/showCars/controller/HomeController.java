package com.showCars.controller;

import com.showCars.pojos.Record;
import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;
import com.showCars.services.*;
import com.showCars.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1324281204513252403L;
    private Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private IModelService modelService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRecordService recordService;
    @Autowired
    private IAdService adService;
    @Autowired
    private IManufacturerService manufacturerService;



    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage2(ModelMap modelMap) {
        User user = userService.findByLogin(Util.getPrincipal());
        List manufacturers = null;
        if (user != null) {
            modelMap.addAttribute("userName", user.getName());
            modelMap.addAttribute("userRole", user.getUserRole().getNameRoleUser());
            try {
                recordService.saveOrUpdate(new Record(user.getId(), user.getName(), Calendar.getInstance().getTime()));
            } catch (Exception e) {
                logger.error("records no saved");
            }
        } else {
            modelMap.addAttribute("userName", "null");
            modelMap.addAttribute("userRole", "null");
            try {
                recordService.saveOrUpdate(new Record(0, "not authorized", new Date()));
            } catch (Exception e) {
                logger.error("records no saved");
            }
        }

        try {
            manufacturers = manufacturerService.getAll();
            modelMap.addAttribute("manufacturers", manufacturers);
        } catch (Exception e) {
            logger.error("Exception in get manufacturers, " + e);
        }

        logger.info("user " + user + " opened the main page");
        return "home";
    }

    @RequestMapping(value = {"/admin"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String admin(HttpSession httpSession) {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            httpSession.setAttribute("userName", user.getName());
            httpSession.setAttribute("userRole", user.getUserRole().getNameRoleUser());
        } else {
            httpSession.setAttribute("userName", "null");
        }
        logger.info("user " + user + " opened the admin page");
        return "admin";
    }

    @RequestMapping(value = {"/user"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String user(HttpSession httpSession) {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            httpSession.setAttribute("userName", user.getName());
            httpSession.setAttribute("userRole", user.getUserRole().getNameRoleUser());
        } else {
            httpSession.setAttribute("userName", "null");
        }
        logger.info("user " + user + " opened the user page");
        return "user";
    }

    @RequestMapping(value = {"/user/createAd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String createAd(ModelMap modelMap) {
        List manufacturers = null;
        List models = null;
        try {
            models = modelService.getModelsByFirstManufacturers();
            manufacturers = manufacturerService.getAll();
            modelMap.addAttribute("models", models);
            modelMap.addAttribute("manufacturers", manufacturers);
        } catch (Exception e) {
            logger.error("Exception in get manufacturers, " + e);
        }
        return "createAd";
    }

    @RequestMapping(value = {"/user/createAdToBase"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String createAdToBase(
            @RequestParam MultipartFile photo, @RequestParam String make, @RequestParam String price,
            @RequestParam String year, @RequestParam String description,
            @RequestParam String model, ModelMap modelMap) throws IOException {

        User user = userService.findByLogin(Util.getPrincipal());
        modelMap.addAttribute("message", "");
        try {
            adService.saveOrUpdate(user, make, model, price, year, description, photo);
        } catch (Exception e) {
            logger.error("Ad had not been saved");
        }

        return "createAdDone";
    }

    @RequestMapping(value = {"/signUp"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String signUp() {
        return "signUp";
    }

    @RequestMapping(value = {"/errorLogin"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String errorLogin(ModelMap model) {
        model.addAttribute("errorLogin", "invalid login and password");
        return "home";
    }

    @RequestMapping(value = {"/signUp/reg"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String addUser(@ModelAttribute("userForm") User user,
                          ModelMap model) throws Exception {
        if (userService.findByLogin(user.getLogin()) == null) {
            UserRole userRole = userService.getRoleUser();
            user.setUserRole(userRole);
            try {
                userService.saveOrUpdate(user);
            } catch (Exception e) {
                return "signUpBad";
            }
        } else {
            model.addAttribute("jsp_message", "this login already exists");
            return "signUp";
        }
        return "signUpSucceful";

    }

}
