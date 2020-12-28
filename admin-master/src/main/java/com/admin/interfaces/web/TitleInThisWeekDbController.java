package com.admin.interfaces.web;

import com.admin.application.TitleInThisWeekDbService;
import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.modle.TitleNameId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/title")
public class TitleInThisWeekDbController {

    @Autowired
    private TitleInThisWeekDbService titleInThisWeekDbService;


    @GetMapping("/allName")
    public @ResponseBody List<String> getAllNames()
    {
       List<TitleInThisWeek> titleInThisWeekList=new ArrayList<>();
       List<String> nameList=new ArrayList<>();
       titleInThisWeekList=getView();
       for(TitleInThisWeek title:titleInThisWeekList)
       {
           nameList.add(title.getName());
       }
        return nameList;
    }
    @GetMapping("/all")
    public @ResponseBody List<TitleInThisWeek> getView()
    {
        Iterable<TitleInThisWeek> titleList=null;
        titleList=titleInThisWeekDbService.getAllXlTitles();
        if(titleList!=null)
        {

           // System.out.println(titleList);
            return  (List<TitleInThisWeek> )titleList;
        }
        else
        {
            return null;
        }


    }
    @GetMapping("/json")
    public @ResponseBody TitleInThisWeek getTitle()
    {
        TitleInThisWeek title =new TitleInThisWeek();
        title.setId(1);
        return title;
    }
    @GetMapping("/allTitles")
    public @ResponseBody List<TitleNameId> getAllTitleList()
    {
        List<TitleInThisWeek> projectTitles=new ArrayList<>();
        // Map<String,Integer>  projectNameMap=new HashMap<>();
        List<TitleNameId> mapList=new ArrayList<TitleNameId>();
        projectTitles=(List<TitleInThisWeek>)titleInThisWeekDbService.getAllXlTitles();
        for(TitleInThisWeek title:projectTitles)
        {
            TitleNameId xlProjectNameId=new TitleNameId();
            xlProjectNameId.setId(title.getId());
            xlProjectNameId.setName(title.getName());

            mapList.add(xlProjectNameId);
            System.out.println(mapList.toString());
        }

        return mapList;
    }


    @GetMapping("/allBdTitles")
    public @ResponseBody List<TitleNameId> getAllBdTitleList()
    {
        List<TitleInThisWeek> projectTitles=new ArrayList<>();
        // Map<String,Integer>  projectNameMap=new HashMap<>();
        List<TitleNameId> mapList=new ArrayList<TitleNameId>();
        projectTitles=(List<TitleInThisWeek>)titleInThisWeekDbService.getAllBdTitles();
        for(TitleInThisWeek title:projectTitles)
        {
            TitleNameId xlProjectNameId=new TitleNameId();
            xlProjectNameId.setId(title.getId());
            xlProjectNameId.setName(title.getName());

            mapList.add(xlProjectNameId);
            System.out.println(mapList.toString());
        }

        return mapList;
    }


//===============================
//@Autowired
//private ProjectXlService projectXlService;
//    @Autowired
//    private XlProgressService xlProgressService;
//
//    @GetMapping("/allxL")
//    public @ResponseBody List<XlProjectNameId> getAllXlList()
//    {
//        List<ProjectXl> projectXls=new ArrayList<>();
//        // Map<String,Integer>  projectNameMap=new HashMap<>();
//        List<XlProjectNameId> mapList=new ArrayList<XlProjectNameId>();
//        projectXls=(List<ProjectXl>)projectXlService.getAllProjects();
//        for(ProjectXl xl:projectXls)
//        {
//            XlProjectNameId xlProjectNameId=new XlProjectNameId();
//            xlProjectNameId.setId(xl.getId());
//            xlProjectNameId.setName(xl.getName());
//
//            mapList.add(xlProjectNameId);
//            System.out.println(mapList.toString());
//        }
//
//        return mapList;
//    }
//
//    @GetMapping("/")
//    public @ResponseBody XlProjectModle getXlShowDetails(@RequestParam("pid") int project_id, @RequestParam("tid")  int title_in_this_week_id)
//    {
//        System.out.println("传入的参数是："+project_id+","+title_in_this_week_id);
//        XlProjectModle rtXlProjectModle=new XlProjectModle();
//        rtXlProjectModle.setProjectXl(projectXlService.getOne(project_id));
//        rtXlProjectModle.setProgressXl(xlProgressService.getAllXlProgress(title_in_this_week_id));
//        return rtXlProjectModle;
//
//    }
//================================




}
