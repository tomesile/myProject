package com.admin.application;


import com.admin.domain.modle.ProgressBd;
import com.admin.domain.modle.TitleInThisWeek;
import com.admin.domain.modle.XlProgress;
import com.admin.domain.repository.TitleInThisWeekRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TitleInThisWeekService implements ITitleInThisWeek{

    private ITitleInThisWeek  projectTitleInThisWeekService;
@Autowired
private TitleInThisWeekRepositry titleInThisWeekRepositry;

    TitleInThisWeekService()
    {

    }

    TitleInThisWeekService(ITitleInThisWeek project)
    {
        projectTitleInThisWeekService=project;


    }
    public List<ProgressBd> getBdProgressById(int id,int projectTypeId)
    {
        TitleInThisWeek titleInThisWeek=titleInThisWeekRepositry.findTitleOne(id,projectTypeId);
        if(titleInThisWeek==null) return null;
       // System.out.println("size:"+titleInThisWeek.getBdList().size());

       // System.out.println("list_now:"+titleInThisWeek.getBdList());
        return titleInThisWeek.getBdList();
    }
    public List<XlProgress> getXlProgressById(int id,int typeId)
    {
        TitleInThisWeek titleInThisWeek=titleInThisWeekRepositry.findTitleOne(id,typeId);
        if(titleInThisWeek==null) return null;
        return titleInThisWeek.getXlList();
    }
    public TitleInThisWeek getTitleById(int titleId,int typeId)
    {
        return titleInThisWeekRepositry.findTitleOne(titleId,typeId);
    }
    public String getTitle(int projectId,int projectTpypeId)
    {
        List<TitleInThisWeek> titleInThisWeekList=new ArrayList();
        titleInThisWeekList=(List<TitleInThisWeek>)titleInThisWeekRepositry.findAllByProductId(projectId,projectTpypeId);
        Date date=new Date();

        for(TitleInThisWeek item:titleInThisWeekList)
        {
            if(date.getDay()-item.getCreateDate().getDay()<=7)
            {
                return item.getName();
            }
        }
        return null;

    }

    public TitleInThisWeek getTitle0(int projectId,int typeId)
    {
        List<TitleInThisWeek> titleInThisWeekList=new ArrayList();
        titleInThisWeekList=(List<TitleInThisWeek>)titleInThisWeekRepositry.findAllByProductId(projectId,typeId);
        Date date=new Date();

        for(TitleInThisWeek item:titleInThisWeekList)
        {
            if(date.getDay()-item.getCreateDate().getDay()<=7)
            {
                return item;
            }
        }
        return null;

    }

    public TitleInThisWeek saveTitle(TitleInThisWeek title)
    {
         return titleInThisWeekRepositry.save(title);
    }
    public void save(TitleInThisWeek title)
    {
        titleInThisWeekRepositry.save(title);
    }
    public int getBdOrXl(){return projectTitleInThisWeekService.getBdOrXl();}

    public ITitleInThisWeek  getProjectType()
    {
        return projectTitleInThisWeekService.getProjectType();
    }

    @Override
    public Boolean isCanCreateTitleInThisWeek() {
        return null;
    }

    public Boolean isCanCreateTitleInThisWeek(int id)
    {
        if(hasNoProgressInThisProject(id))
        {
            return true;
        }
        else if(hasNoProgressInThisWeek(id))
        {
            return true;
        }
        return false;
    }


    public boolean hasNoProgressInThisProject(int id)
    {
        TitleInThisWeekService service;

        if(getBdOrXl()==0) {//变电工程需要调用变电相关的工程服务
            service = (BdTitleInThisWeekService) getProjectType();
            ((BdTitleInThisWeekService) service).getProjectService();
        }
        else if(getBdOrXl()==1)//线路工程需要调用线路相关的工程服务
    {
            service=  (XlTitleInThisWeekService)getProjectType();
        ((XlTitleInThisWeekService)service).getProjectService().hasProgressCount(id);
        }
        return false;
    }
    public boolean hasNoProgressInThisWeek( int id)
    {
        return false;
    }
}
