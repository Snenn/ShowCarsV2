package com.showCars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "home";
    }

    @RequestMapping(value = {"/showcars"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String showCarsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "showCars";
    }
}
