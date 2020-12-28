package com.admin.interfaces.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showProjectBd")
public class ShowProjectBd {

    @GetMapping
    public String showProjectBd()
    {
       return "/showProjectBd";
    }


}
