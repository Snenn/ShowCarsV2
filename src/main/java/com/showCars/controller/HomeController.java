package com.showCars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Controller
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1324281204513252403L;


    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "home";
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage2(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "home";
    }

    @RequestMapping(value = {"/showcars"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String showCarsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "showCars";
    }
}
