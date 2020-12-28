package com.admin.application;

import com.admin.domain.modle.ProgressBd;
import com.admin.domain.modle.ProjectBd;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBdProjects {

    public static List<Map<ProgressBd, ProjectBd>> getBdProjects(List<ProgressBd> progressBdList)
    {

        List<Map<ProgressBd,ProjectBd>> list=new ArrayList();
        if(progressBdList.isEmpty()) return null;
        for(ProgressBd bd:progressBdList)
        {
            Map<ProgressBd,ProjectBd> rtMap=new HashMap<>();
            ProjectBd projectBd=bd.getProjectBd();
            rtMap.put(bd,projectBd);
            list.add(rtMap);
        }
        return list;
    }

}
