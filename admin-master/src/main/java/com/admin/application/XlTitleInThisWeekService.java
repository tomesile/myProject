package com.admin.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XlTitleInThisWeekService extends TitleInThisWeekService {

    @Autowired
            private ProjectXlService projectXlService;
    @Autowired
            private XlProgressService xlProgressService;

    XlTitleInThisWeekService()
    {
        new XlTitleInThisWeekService(this);
    }

    XlTitleInThisWeekService(ITitleInThisWeek  titleInThisWeekService) {
        super(titleInThisWeekService);
    }
    public int getBdOrXl()
    {
        return 1;
    }
    public ProjectXlService getProjectService()
    {
        return projectXlService;
    }
    public XlProgressService getProgressService()
    {
        return xlProgressService;
    }


    public ITitleInThisWeek getProjectType()
    {
        return this;
    }
    public boolean isCanCreateXlTitleInThisWeek()
    {
        return isCanCreateTitleInThisWeek();
    }
    public boolean hasNoXlProgressInThisProject(int id)
    {
        return hasNoProgressInThisProject(id);
    }
    public boolean hasNoXlProgressInThisWeek(int id)
    {
        return hasNoProgressInThisWeek(id);
    }
    public boolean findProgressCount(int id){return projectXlService.hasProgressCount(id);}
}
