package com.admin.interfaces.web;

import com.admin.application.ProjectBdService;
import com.admin.domain.modle.ProjectBd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/updateProjectBd")
public class updateProjectBdController {

    @Autowired
    private  ProjectBdService projectBdService;
    @GetMapping
    public String getView(Model mode)
    {
        mode.addAttribute("Bdmode",projectBdService.getOneProjectBd(7));
        System.out.println(mode.toString());
        return "/updateProjectBd";
    }

    @PostMapping
    public String updadeProjectBd(@Valid ProjectBd projectBd, @RequestParam("name") String name, Errors errors)
    {
        if(errors.hasErrors()){return "/430";}
        projectBdService.update(projectBd, name,7);
        return "/updateProjectBd";
    }
}
