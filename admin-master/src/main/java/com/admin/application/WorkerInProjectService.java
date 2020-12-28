package com.admin.application;

import com.admin.domain.modle.WorkerInProject;
import com.admin.infrastructure.persistence.jdbc.WorkerInProjectRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class WorkerInProjectService {
    @Autowired
    protected WorkerInProjectRepositoryJPA workerInProject;
    @Modifying
    @Query("update WorkerInProject wip set wip.projectManager=:projectManager,wip.ManagerPhoneNum=:ManagerPhoneNum,wip.chiefEngineer=:chiefEngineer,wip.chiefEngineerPhoneNum=:chiefEngineerPhoneNum,wip.workerCountInComp=:workerCountInComp,wip.workerOutProject=:workerOutProject where wip.id=:id")
    public void update(WorkerInProject wip)
    {
        workerInProject.save(wip);
    }

    public void delete(WorkerInProject wip)
    {
        workerInProject.delete(wip);
    }

    public void deleteById(int id)
    {
        workerInProject.delete(id);
    }
}
