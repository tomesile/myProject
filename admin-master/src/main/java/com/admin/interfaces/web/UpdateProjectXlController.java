package com.admin.interfaces.web;

import com.admin.domain.modle.ProjectXl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/updateProjectXl")
public class UpdateProjectXlController {
    @GetMapping
    public String getView()
    {


        return "/updateProjectXl";
    }
    @PostMapping
    public String updateProjectXl(@Valid ProjectXl xl, Errors errors, @ModelAttribute ProjectXl xlMode)
    {
        if(errors.hasErrors()){return "/403";}

        return "/updateProjectXl";
    }

}
