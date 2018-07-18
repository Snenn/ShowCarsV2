package com.showCars.controller;

import com.showCars.Util.Util;
import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;
import com.showCars.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        User user = userService.findByLogin(Util.getPrincipal());
        if (user != null) {
            httpSession.setAttribute("userName", user.getName() + " " + user.getSurname());
        } else {
            httpSession.setAttribute("userName", "null");
        }
        return "home";
    }

    @RequestMapping(value = {"/showCars"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String showCarsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        List<User> users = userService.getAll();
        System.out.println("userList: " + users);
        model.addAttribute("users", users);
        return "showCars";
    }

    @RequestMapping(value = {"/signUp"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String signUp(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        return "signUp";
    }
    @RequestMapping(value = {"/errorLogin"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String errorLogin(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        model.addAttribute("errorLogin", "invalid login and password");
        return "home";
    }

    @RequestMapping(value = {"/signUp/reg"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String addUser(@ModelAttribute("userForm") User user,
                          HttpServletRequest request,ModelMap model) throws Exception {
        if (userService.findByLogin(user.getLogin()) == null) {
            UserRole userRole=userService.getRoleUser();
            user.setUserRole(userRole);
            userService.saveOrUpdate(user);
            model.addAttribute("jsp_message", "successful");
            return "signUpSucceful";
        } else {
            model.addAttribute("jsp_message", "this login already exists");
            return "signUp";
        }
    }

}
