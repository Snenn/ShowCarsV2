package com.showCars.controller;

import com.showCars.pojos.Record;
import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;
import com.showCars.services.IRecordService;
import com.showCars.services.IUserService;
import com.showCars.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Controller
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1324281204513252403L;
    private Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IRecordService recordService;



    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage2(HttpSession httpSession) {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            httpSession.setAttribute("userName", user.getName() + " " + user.getSurname());
            try {
                recordService.saveOrUpdate(new Record(user.getId(), user.getName(), Calendar.getInstance().getTime()));
            } catch (Exception e) {
                logger.error("records no saved");
            }
        } else {
            httpSession.setAttribute("userName", "null");
            try {
                recordService.saveOrUpdate(new Record(0, "not authorized", new Date()));
            } catch (Exception e) {
                logger.error("records no saved");
            }
        }
        logger.info("user " + user + " opened the main page");
        return "home";
    }

    @RequestMapping(value = {"/admin"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String admin(HttpSession httpSession) {
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            httpSession.setAttribute("userName", user.getName());
        } else {
            httpSession.setAttribute("userName", "null");
        }
        logger.info("user " + user + " opened the main page");
        return "admin";
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
