package com.metacube.training.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeToWebsite {
    @RequestMapping(value = "/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error == null) {
            model.addAttribute("error", null);
        } else {
            model.addAttribute("error", "error");
        }
        return "login";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String afterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/employee/dashboard";
    }
}
