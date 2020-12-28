package com.admin.application;

public interface ITitleInThisWeek {

    int getBdOrXl();
    ITitleInThisWeek getProjectType();
    public Boolean isCanCreateTitleInThisWeek();
    public boolean hasNoProgressInThisProject(int id);
    public boolean hasNoProgressInThisWeek(int id);


}
