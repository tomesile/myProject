package com.admin.interfaces.web;

import com.admin.application.TitleInThisWeekService;
import com.admin.domain.modle.*;
import com.admin.domain.repository.TitleInThisWeekRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("getAllDetails")
public class GetDetailController {

    @Autowired
    private TitleInThisWeekService titleInThisWeekService;

    @GetMapping("/xl")
    public @ResponseBody  List<Map<String,ProjectXl>> getXlInfos(@Param("id") int id, @Param("typeId")int typeId)
    {
        return getXlProjectList(getXlProjectByTitle(id,typeId));
    }
    @GetMapping("/bdProgress")
    public @ResponseBody List<ProgressBd> getBdProgressByTitles(@Param("id") int id, @Param("typeId") int typeId)
    {
        // System.out.println("list:"+titleInThisWeekService.getBdProgressById(titleId,typeId).toString());

        if(id<=0||typeId!=1)
            return null;
        //  System.out.println("list:"+titleInThisWeekService.getBdProgressById(titleId,typeId).toString());
        return  titleInThisWeekService.getBdProgressById(id,typeId);
    }

    @GetMapping("/bd")
    public @ResponseBody  List<Map<String,ProjectBd>> getBdInfos(@Param("id") int id,@Param("typeId") int typeId)
    {
        return getBdProjectList(getBdProgressByTitle(id,typeId));
    }

    public  List<ProgressBd> getBdProgressByTitle(int titleId, int typeId)
    {
       // System.out.println("list:"+titleInThisWeekService.getBdProgressById(titleId,typeId).toString());

        if(titleId<=0||typeId!=1)
        return null;
      //  System.out.println("list:"+titleInThisWeekService.getBdProgressById(titleId,typeId).toString());
       return  titleInThisWeekService.getBdProgressById(titleId,typeId);
    }
    @GetMapping("/xllist")
    public @ResponseBody List<XlProgress> getXlProjectByTitle(@Param("id") int id, @Param("typeId") int typeId)
    {
        if(id<=0||typeId!=0)
            return null;
        return  titleInThisWeekService.getXlProgressById(id,typeId);
    }


    public   List<Map<String,ProjectBd>> getBdProjectList(List<ProgressBd> progressBdList)
    {

        List<Map<String ,ProjectBd>> list=new ArrayList();
        if(progressBdList.isEmpty()) return null;
        int num=0;
        for(ProgressBd bd:progressBdList)
        {

            Map<String,ProjectBd> rtMap=new HashMap<>();
            ProjectBd projectBd=(ProjectBd)bd.getProjectBd();
            String strId=String.valueOf(num++);
            rtMap.put(strId,projectBd);
            list.add(rtMap);
        }
        return list;
    }


    public   List<Map<ProgressBd,ProjectBd>> getBdProjects(List<ProgressBd> progressBdList)
    {

        List<Map<ProgressBd,ProjectBd>> list=new ArrayList();
        if(progressBdList.isEmpty()) return null;
        for(ProgressBd bd:progressBdList)
        {
            Map<ProgressBd,ProjectBd> rtMap=new HashMap<>();
            ProjectBd projectBd=(ProjectBd)bd.getProjectBd();
            rtMap.put(bd,projectBd);
            list.add(rtMap);
        }
        return list;
    }
   // @GetMapping("/xlInfos")
    public   List<Map<XlProgress,ProjectXl>> getXlProjects(List<XlProgress> progressXlList)
    {

        List<Map<XlProgress,ProjectXl>> list=new ArrayList();
        if(progressXlList.isEmpty()) return null;
        for(XlProgress xl:progressXlList)
        {
            Map<XlProgress,ProjectXl> rtMap=new HashMap<>();
            ProjectXl projectXl=xl.getProjectXl();
            rtMap.put(xl,projectXl);
            list.add(rtMap);
        }
        return list;
    }
    public   List<Map<String,ProjectXl>> getXlProjectList(List<XlProgress> progressXlList)
    {

        List<Map<String,ProjectXl>> list=new ArrayList();
        if(progressXlList.isEmpty()) return null;
        int num=0;
        for(XlProgress xl:progressXlList)
        {
            Map<String,ProjectXl> rtMap=new HashMap<>();
            ProjectXl projectXl=xl.getProjectXl();
            String strId=String.valueOf(num++);
            rtMap.put(strId,projectXl);
            list.add(rtMap);
        }
        return list;
    }

}
