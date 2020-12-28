package com.admin.interfaces.web;

import com.admin.application.ProjectService;
import com.admin.domain.modle.ProjectClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projectDelete")
public class DeleteProjectController {
    @Autowired
    private ProjectService projectService;
     @PostMapping
    public String delete(@RequestParam("id") int id, @Valid ProjectClass pro, Errors errors, @ModelAttribute ProjectClass mod)
    {
        if(errors.hasErrors()){return "/error/403";}
        projectService.delete(pro.getId());
        return "/projectDelete";
    }
    @GetMapping
    public String getView()
    {
        return "/projectDelete";
    }

}
