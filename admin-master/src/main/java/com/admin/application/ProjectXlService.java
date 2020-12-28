package com.admin.application;

import com.admin.domain.modle.*;

import com.admin.infrastructure.persistence.jdbc.ProjectRepository;
import com.admin.infrastructure.persistence.jdbc.ProjectXlRepository;
import com.admin.infrastructure.persistence.jdbc.SubCompanyRepositoryJPA;
import com.admin.infrastructure.persistence.jdbc.WorkerInProjectRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectXlService {
    @Autowired
    protected ProjectXlRepository projectXlRepository;
    @Autowired
    protected ProjectRepository projectRepository;
   @Autowired
    protected SubCompanyRepositoryJPA subCompanyRepositoryJPA;
    @Autowired
    protected WorkerInProjectRepositoryJPA workerInProjectRepositoryJPA;
    public Iterable<ProjectXl> getAllProjects()
    {
        return projectXlRepository.findAll();
    }

    public  void save(ProjectXl pro)
    {
        projectXlRepository.save(pro);
    }
    @Modifying
    @Query("update ProjectXl pc set pc.name = :name , pc.subCompany= :subCompany ,pc.workerInProject=:workerInProject  where pc.id = :id")
    public void update(ProjectXl pro,String name, int id)
    {

     //   pro.setName(name);
      //  pro.setCreateDate(new Date());
        ProjectClass pjc=new ProjectClass();
       // pjc.setId(findProjectId(id));
       // pro.setRoot(pjc);
        pro.setCreateDate(new Date());
       // findCompanyId(id);
        //projectRepository.save(pjc);
        updateCompany(pro.getSubCompany(),pro.getSubCompany().getName(),findCompanyId(id));
        updateInProjectWorker(pro.getWorkerInProject(),pro.getWorkerInProject().getProjectManager(),findWorkerInProjectId(id));
        projectXlRepository.save(pro);
    }
    @Modifying
    @Query("update SubCompany sc set sc.name = :name  where sc.id = :id")
    public void updateCompany(SubCompany scc,String name,int id)
    {
       // SubCompany sc=new SubCompany();
        scc.setId(id);
        subCompanyRepositoryJPA.save(scc);
    }
    @Modifying
    @Query("update WorkerInProject sc set sc.projectManager = :projectManager  where sc.id = :id")
    public void updateInProjectWorker(WorkerInProject wip,String projectManager,int id)
    {
        wip.setId(id);
        workerInProjectRepositoryJPA.save(wip);
    }

    public int findCompanyId(int id)
    {
        ProjectXl projectXl=new ProjectXl();
        projectXl= projectXlRepository.findOne(id);

        return projectXl.getSubCompany().getId();
    }
    public int findWorkerInProjectId(int id)
    {
        ProjectXl projectXl=new ProjectXl();
        projectXl= projectXlRepository.findOne(id);

        return projectXl.getWorkerInProject().getId();
    }
   // public int findProjectId(int id)
   // {
   //    ProjectXl projectXl=new ProjectXl();
     //   projectXl= projectXlRepository.findOne(id);

      //  return projectXl.getRoot().getId();
   // }
    public void delete(ProjectXl pro)
    {
        projectXlRepository.delete(pro);
    }
    public void delete(int id)
    {
        projectXlRepository.delete(id);
    }
    public ProjectXl getOne(int project_id)
    {
        return projectXlRepository.findOne(project_id);
    }
    public boolean hasProgressCount(int id)
    {
       return projectXlRepository.findProgressXlLsitById(id).iterator().hasNext();
    }
}
