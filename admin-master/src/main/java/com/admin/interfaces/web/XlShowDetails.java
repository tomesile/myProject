package com.admin.interfaces.web;

import com.admin.application.ProjectXlService;
import com.admin.application.XlProgressService;
import com.admin.domain.modle.ProjectXl;
import com.admin.domain.modle.XlProjectModle;
import com.admin.domain.modle.XlProjectNameId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xlShowDetails")
public class XlShowDetails {

    @Autowired
    private ProjectXlService projectXlService;
    @Autowired
    private XlProgressService xlProgressService;

    @GetMapping("/allxL")
    public @ResponseBody List<XlProjectNameId> getAllXlList()
    {
        List<ProjectXl> projectXls=new ArrayList<>();
       // Map<String,Integer>  projectNameMap=new HashMap<>();
        List<XlProjectNameId> mapList=new ArrayList<XlProjectNameId>();
        projectXls=(List<ProjectXl>)projectXlService.getAllProjects();
        for(ProjectXl xl:projectXls)
        {
            XlProjectNameId xlProjectNameId=new XlProjectNameId();
            xlProjectNameId.setId(xl.getId());
            xlProjectNameId.setName(xl.getName());

            mapList.add(xlProjectNameId);
            System.out.println(mapList.toString());
        }

        return mapList;
    }

    @GetMapping("/")
    public @ResponseBody XlProjectModle getXlShowDetails(@RequestParam("pid") int project_id, @RequestParam("tid")  int title_in_this_week_id)
    {
        System.out.println("传入的参数是："+project_id+","+title_in_this_week_id);
        XlProjectModle rtXlProjectModle=new XlProjectModle();
        rtXlProjectModle.setProjectXl(projectXlService.getOne(project_id));
        rtXlProjectModle.setProgressXl(xlProgressService.getAllXlProgress(title_in_this_week_id));
        return rtXlProjectModle;

    }
}
