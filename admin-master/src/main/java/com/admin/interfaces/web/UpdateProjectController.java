package com.admin.interfaces.web;

import com.admin.application.ProjectService;
import com.admin.application.ProjectXlService;
import com.admin.domain.modle.ProjectClass;
import com.admin.domain.modle.ProjectXl;
import com.admin.domain.modle.SubCompany;
import com.admin.domain.modle.WorkerInProject;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projectXlShow")
public class UpdateProjectController {
    @Autowired
    private ProjectXlService projectXlService;
    @Autowired
    private ProjectXlRepository projectXlRepository;

    @PostMapping("/projectXlUpdate")
    public String updateProject(@RequestParam("id") int id, @Valid ProjectXl pro, @Valid SubCompany subCompany, @Valid WorkerInProject workerInProject, Errors errors, @ModelAttribute ProjectXl proAtr)
    {
        if(errors.hasErrors()){return "/430";}
        ProjectClass pj=new ProjectClass();
        pj.setId(3);
        projectXlService.update(pro,pro.getName(),pro.getId());
        return "/projectXlUpdate";

    }
    @GetMapping
    public String getView(Model model)
    {

        model.addAttribute("xlmode",projectXlRepository.findOne(11));

        return "/projectXlShow";
    }

}
