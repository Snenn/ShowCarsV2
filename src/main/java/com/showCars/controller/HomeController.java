package com.showCars.controller;

import com.showCars.pojos.User;
import com.showCars.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@Controller
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1324281204513252403L;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "home";
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String homePage2(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "home";
    }

    @RequestMapping(value = {"/showCars"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String showCarsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        List<User> users = userService.getAll();
        System.out.println("userList: "+users);
        model.addAttribute("users",users);
        return "showCars";
    }
}
