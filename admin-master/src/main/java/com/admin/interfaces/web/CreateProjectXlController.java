package com.admin.interfaces.web;

import com.admin.domain.modle.ProjectClass;
import com.admin.domain.modle.ProjectXl;
import com.admin.domain.modle.SubCompany;
import com.admin.domain.modle.WorkerInProject;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import com.admin.infrastructure.persistence.jdbc.SubCompanyRepositoryJPA;
import com.admin.infrastructure.persistence.jdbc.WorkerInProjectRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/createProjectXl")
public class CreateProjectXlController {
    @Autowired
    private final ProjectXlRepository projectXlRepository;
    @Autowired
    private final SubCompanyRepositoryJPA subCompanyRepositoryJPA;
    @Autowired
    private final WorkerInProjectRepositoryJPA workerInProjectRepositoryJPA;

    public CreateProjectXlController(ProjectXlRepository projectXlRepository, SubCompanyRepositoryJPA subCompanyRepositoryJPA, WorkerInProjectRepositoryJPA workerInProjectRepositoryJPA) {
        this.projectXlRepository = projectXlRepository;
        this.subCompanyRepositoryJPA = subCompanyRepositoryJPA;
        this.workerInProjectRepositoryJPA = workerInProjectRepositoryJPA;
    }

    @GetMapping
    public String  getView()
    {
        return "createProjectXl";
    }
    @PostMapping
    public String  createProjectXl(@Valid ProjectXl xl, Errors errors, @ModelAttribute ProjectXl xlMode)
    {
        try {
            if (errors.hasErrors())
                System.out.println("createProjectXl now");
            System.out.println(xl.toString());
            SubCompany subCompany = new SubCompany();
            subCompany.setName(xl.getSubCompany().getName());
            subCompanyRepositoryJPA.save(subCompany);
            ProjectXl projectXl = new ProjectXl();
            projectXl.setSubCompany(subCompany);
            projectXl.setName(xl.getName());
            WorkerInProject workerInProject = new WorkerInProject();
            workerInProject.setProjectManager(xl.getWorkerInProject().getProjectManager());
            workerInProject.setManagerPhoneNum(xl.getWorkerInProject().getManagerPhoneNum());
            workerInProject.setChiefEngineer(xl.getWorkerInProject().getChiefEngineer());
            workerInProject.setChiefEngineerPhoneNum(xl.getWorkerInProject().getChiefEngineerPhoneNum());
            workerInProject.setWorkerCountInComp(xl.getWorkerInProject().getWorkerCountInComp());
            workerInProject.setWorkerOutProject(xl.getWorkerInProject().getWorkerOutProject());
            workerInProjectRepositoryJPA.save(workerInProject);
            projectXl.setWorkerInProject(workerInProject);
            // projectXl.setStatusContent(xl.getStatusContent());
          //  ProjectClass projectClass = new ProjectClass();
         //   projectClass.setId(3);
            // projectClass.setName(xl.getName());
          //  projectXl.setRoot(projectClass);
            projectXl.setCreateDate(new Date());
            projectXlRepository.save(projectXl);
        }
        catch(DataIntegrityViolationException de){
        throw de;
    }


        return "createProjectXl";
    }
}
