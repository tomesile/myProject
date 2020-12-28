package com.admin.domain.modle;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

import javax.persistence.*;

//工程类（线路）
@Data
@Entity
public class ProjectXl  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
   private Date createDate;
   //对应项目人员投入
   @OneToOne(targetEntity=WorkerInProject.class)
   private WorkerInProject workerInProject;
   //对应所属分公司
   @OneToOne(targetEntity = SubCompany.class)
   private SubCompany subCompany;

   //对应分包商分工及施工进度情况
  // @OneToOne(targetEntity =ProgressStatus.class )
  // private ProgressStatus progressStatus;
   //一个线路工程属于一个工程项目
  // @OneToOne(targetEntity=ProjectClass.class)
  //   private ProjectClass root=new ProjectClass();
   //一个线路工程对应多个进度
    @OneToMany(targetEntity= XlProgress.class)
   private List<XlProgress> progressXlLsit=new ArrayList<>();
    @OneToMany(targetEntity = TitleInThisWeek.class)
    private List<TitleInThisWeek> titleInThisWeek=new ArrayList<>();
    @Override
    public String toString() {
        return "ProjectXl";
    }

}
