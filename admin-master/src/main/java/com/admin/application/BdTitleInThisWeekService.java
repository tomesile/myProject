package com.admin.application;

import com.admin.domain.modle.TitleInThisWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdTitleInThisWeekService extends TitleInThisWeekService {
    @Autowired
    private ProjectBdService projectBdService;
    @Autowired
    private BdProgressService bdProgressService;

    BdTitleInThisWeekService()
    {
        new BdTitleInThisWeekService(this);
    }
    BdTitleInThisWeekService(ITitleInThisWeek iTitleInThisWeek)
    {
        super(iTitleInThisWeek);
    }
    public int getBdOrXl()
    {
        return 0;
    }
    public ProjectBdService getProjectService()
    {
        return projectBdService;
    }

    public BdProgressService getProgressService() {
        return bdProgressService;
    }

    public ITitleInThisWeek getProjectType()
    {
        return this;
    }
    public Boolean isCanCreateBdTitleInThisWeek()
    {
        return isCanCreateTitleInThisWeek();

    }

    public boolean hasNoBdProgressInThisProject(int id)
    {
        return hasNoProgressInThisProject(id);
    }
    public boolean hasNoBdProgressInThisWeek(int id)
    {
        return hasNoProgressInThisWeek(id);
    }
}
