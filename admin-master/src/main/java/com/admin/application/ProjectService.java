package com.admin.application;

import com.admin.domain.modle.ProjectClass;
import com.admin.infrastructure.persistence.jdbc.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    protected ProjectRepository projectRepository;

    public  void save(ProjectClass pro)
    {
        projectRepository.save(pro);
    }
    @Modifying
    @Query("update ProjectClass pc set pc.name = :name where pc.id = :id")
    public void update(ProjectClass pro,String name,int id)
    {
        pro.setName(name);
        pro.setCreateDate(new Date());
        projectRepository.save(pro);
    }
    public void delete(ProjectClass pro)
    {
        projectRepository.delete(pro);
    }
    public void delete(int id)
    {
        projectRepository.delete(id);
    }
}
