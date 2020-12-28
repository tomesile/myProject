package com.admin.application;

import com.admin.domain.modle.*;
import com.admin.domain.repository.ProjectAllInfosRepository;
import com.admin.domain.repository.ProjectBdRepository;
import com.admin.domain.repository.TypeWorkRepository;
import com.admin.domain.repository.TypewsRepository;
import com.admin.infrastructure.persistence.jdbc.SubCompanyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectBdService {
    @Autowired
    private TypeWorkRepository typeWorkRepository;
    @Autowired
    private TypewsRepository typewsRepository;
    @Autowired
    private ProjectAllInfosRepository projectAllInfosRepository;
    @Autowired
    private ProjectBdRepository projectBdRepository;
    @Autowired
    private SubCompanyRepositoryJPA subCompanyRepositoryJPA;

    public Iterable<ProjectBd> getAllProjects()
    {
        return projectBdRepository.findAll();
    }

    public ProjectBd getOneProjectBd(int id)
    {
        return projectBdRepository.findOne(id);
    }

    public void update(ProjectBd projectBd, String name,int id)
    {
       ProjectBd bd=new ProjectBd();
        bd.setCreateDate(new Date());
        bd.setId(id);
       // updateTypews(findTypewsByProjectAllInfos(id),findTypewsId(id));
        int size=findTypeWorkByProjectAllInfos(id).size();
        for(int i=0;i<size;i++)
        {
            updateTypeWork(findTypeWorkByProjectAllInfos(id),findTypeWorkId(id,i));
        }
        int size0=findSubCompanyByProjectAllInfos(id).size();
        System.out.println("size0"+size0);
        for(int i=0;i<size0;i++)
        {
            updateSubCompany(findSubCompanyByProjectAllInfos(id),findSubCompanyId(id,i));
            System.out.println(findSubCompanyByProjectAllInfos(id).toString());
        }

        updateProjectAllInfos(projectBd.getProjectAllInfos(),findProjectAllInfosId(id));

        projectBdRepository.save(bd);

    }


    //--------------------保存subCompany开始-----------------------------


        public int findSubCompanyId(int id,int idd)
        {
            return findSubCompanyByProjectAllInfo(id,idd).getId();
        }
       public List<SubCompany> findSubCompanyByProjectAllInfos(int id)
       {
           ProjectAllInfos info= findProjectAllInfos(id);
           List<SubCompany> subCompany= info.getSubCompany();

           //待写
           return subCompany;
       }

       public void updateSubCompany(List<SubCompany> subCompanyList,int id)
       {
           for(SubCompany wt:subCompanyList)
           {
               if(wt.getId()==id)
               {
                   wt.setId(id);

                  System.out.println("id:"+id+":"+wt.getName());

                   subCompanyRepositoryJPA.save(wt);
               }

           }
       }
       public SubCompany findSubCompanyByProjectAllInfo(int id,int index)
        {
        List<SubCompany>  tw=findSubCompanyByProjectAllInfos(id);
          int idd=0;
          for(SubCompany w:tw)
         {
            if(idd==index)
                return w;
            idd++;
         }
         return null;

         }
    //--------------------保存subCompany完成-----------------------------
  //  public int  findTypewsId(int id)
   // {
   //     return findTypewsByProjectAllInfos(id).getId();
   // }

    public int findTypeWorkId(int id,int idd)
    {
        return findTypeWorkByProjectAllInfo(id,idd).getId();
    }

     public int findProjectAllInfosId(int id)
     {
         return findProjectAllInfos(id).getId( );
     }

     //得到ProjectAllInfos
    public ProjectAllInfos findProjectAllInfos(int id)
    {
        ProjectAllInfos info= projectBdRepository.findOne(id).getProjectAllInfos();
        return info;
    }
//得到TypeWork
    public List<TypeWork> findTypeWorkByProjectAllInfos(int id)
    {
        ProjectAllInfos info= findProjectAllInfos(id);
        List<TypeWork> typeWorks= info.getTypeWorkList();

        //待写
        return typeWorks;
    }
    public TypeWork findTypeWorkByProjectAllInfo(int id,int index)
    {
        List<TypeWork>  tw=findTypeWorkByProjectAllInfos(id);
        int idd=0;
        for(TypeWork w:tw)
        {
            if(idd==index)
            return w;
            idd++;
        }
        return null;

    }
////得到Typews
   // public Typews findTypewsByProjectAllInfos(int id)
   // {
   //     List<TypeWork> typeWork=findTypeWorkByProjectAllInfos(id);
//待写
   //     for(TypeWork tw:typeWork)
   //     {
    //        Typews typews=tw.getTYpe();
    //        return typews;
    //    }
   //     return null;
  //  }

    public void save(ProjectAllInfos projectAllInfos, ProjectBd bd)
    {

        projectAllInfosRepository.save(projectAllInfos);
        projectBdRepository.save(bd);
    }

    public void updateTypews(Typews ws,int id)
    {

        ws.setId(id);
        typewsRepository.save(ws);
    }

    public void updateTypeWork(List<TypeWork> twList,int id)
    {
        for(TypeWork wt:twList)
        {
            if(wt.getId()==id)
            {
                wt.setId(id);

                typeWorkRepository.save(wt);
            }

        }

    }
    @Modifying
    @Query("update ProjectAllInfos sc set sc.subCompany = :subCompany  where sc.id = :id")
    public void updateProjectAllInfos(ProjectAllInfos projectAllInfos,int id)
    {
        projectAllInfos.setId(id);
       // projectAllInfos.setCreateDate(new Date());
        projectAllInfos.setProjectStartTime(new Date());
        projectAllInfos.setProjectEndTime(new Date());
        projectAllInfosRepository.save(projectAllInfos);
    }

}
