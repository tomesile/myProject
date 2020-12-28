package com.admin.interfaces.web;

import com.admin.domain.modle.ProjectBzd;
import com.admin.domain.modle.ProjectClass;
import com.admin.domain.modle.ProjectXl;
import com.admin.infrastructure.persistence.jdbc.ProjectRepository;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import com.sun.tools.javac.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.io.Console;
import java.util.Date;

@Controller
@RequestMapping("/createProject")
public class CreateProjectController {

    private final ProjectRepository projectRepository;
   // private final ProjectXlRepository projectXlRepository;

    @Autowired
    public CreateProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
       // this.projectXlRepository = projectXlRepository;
    }
    @PostMapping
    public String createProject(@RequestParam("name") String strProjectType, @Valid ProjectClass projectCls, Errors errors, @ModelAttribute ProjectClass project)
    {
        if (errors.hasErrors()) {
            return "/403";
        }
       // if(strProjectType=="xl") {
            projectCls.setCreateDate(new Date());
        projectRepository.save(projectCls);
        //    return "index";
       // }
      //   if(strProjectType=="bdz")
      //  {
          //  projectRepository.save((ProjectBzd)projectCls);
      //  }
        return "/createProject";
    }
    @GetMapping()
    public String getView()
    {
        return "/createProject";
    }



}
