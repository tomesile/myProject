package com.admin.interfaces.web;

import com.admin.domain.modle.ProjectXl;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/deleteProjectXl")
public class DeleteProjectXlController  {
    @Autowired
    private final ProjectXlRepository projectXlRepository;

    public DeleteProjectXlController(ProjectXlRepository projectXlRepository) {
        this.projectXlRepository = projectXlRepository;
    }

    @GetMapping
    public String getView()
    {
        return "/deleteProjectXl";
    }
    @PostMapping
    public String deleteProjectXl(@RequestParam("id")  int id, @Valid ProjectXl xl, Errors errors, @ModelAttribute ProjectXl mode)
    {
        if(errors.hasErrors()){return "/403";}
        projectXlRepository.delete(id);
        return "/deleteProjectXl";
    }
}
