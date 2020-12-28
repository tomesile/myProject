package com.admin.interfaces.web;

import com.admin.application.ProjectBdService;
import com.admin.domain.modle.*;
import com.admin.domain.repository.TypeWorkRepository;
import com.admin.domain.repository.TypewsRepository;
import com.admin.infrastructure.persistence.jdbc.SubCompanyRepositoryJPA;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.OneToMany;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/createProjectBd")
public class CreateProjectBdController {

    @Autowired
    private ProjectBdService projectBdService;
    @Autowired
    private TypewsRepository typewsRepository;
    @Autowired
    private TypeWorkRepository typeWorkRepository;
    @Autowired
    private SubCompanyRepositoryJPA subCompanyRepositoryJPA;

    @PostMapping
    public String createProjectBd(@Valid ProjectBd bd, Errors errors, @ModelAttribute ProjectBd mode )
    {
        if(errors.hasErrors()){return "/403";}
        ProjectBd savedBd=new ProjectBd();
        savedBd.setCreateDate(new Date());
        ProjectAllInfos projectAllInfos=new ProjectAllInfos();

        List<SubCompany> subCompanyList=new ArrayList<SubCompany>();

        List<TypeWork> typeWorkList=new ArrayList<TypeWork>();
        Typews typews=new Typews();
       // typews.setTYpe(bd.getProjectAllInfos().getTypeWorkList().getTYpe().getName());
        System.out.println(bd.toString());


        for(SubCompany sc:bd.getProjectAllInfos().getSubCompany())
        {
            //int i=0;
            SubCompany scc=new SubCompany();
            scc.setName(sc.getName());
           // scc.setId(sc.getId()+i);
            subCompanyRepositoryJPA.save(scc);
            subCompanyList.add(scc);
           // i++;
        }
        for(TypeWork tws:bd.getProjectAllInfos().getTypeWorkList())
        {
          //  int i=0;
          //  typews.setTypeName(tws.getTYpe().getTypeName());
          //  typewsRepository.save(typews);
           // tw.setTYpe(typews);
           // tw.setId(tws.getId()+i);
            System.out.println("TypeWork:"+tws.getManagerName());
            TypeWork tw=new TypeWork();
            tw.setManagerName(tws.getManagerName());
            tw.setPhoneNum(tws.getPhoneNum());
            typeWorkRepository.save(tw);
            typeWorkList.add(tw);
          //  i++;

        }
        //bd.getProjectAllInfos().getProjectStartTime()
        savedBd.setName(bd.getName());
        projectAllInfos.setProjectStartTime(new Date(bd.getProjectAllInfos().getProjectStartTime().toString()));
        projectAllInfos.setProjectEndTime(new Date(bd.getProjectAllInfos().getProjectEndTime().toString()));
        projectAllInfos.setTypeWorkList(typeWorkList);
        projectAllInfos.setSubCompany(subCompanyList);
        savedBd.setProjectAllInfos(projectAllInfos);




       // List<SubCompany> subCompany=new ArrayList<SubCompany>();
        //subCompany.setSubCompany(bd.getSubCompany);

         projectBdService.save(projectAllInfos,savedBd);
        return "showProjectBd";
    }
    @GetMapping
    public String getView()
    {
        return "/createProjectBd";
    }
    
}
