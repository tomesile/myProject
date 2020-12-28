package com.admin.domain.modle;

//工程项目中人员投入情况

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Data
@Entity
public class WorkerInProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectManager;
    private String ManagerPhoneNum;
    private String chiefEngineer;
    private String chiefEngineerPhoneNum;
    private int workerCountInComp;
    private int workerOutProject;
    public int getWorkerCount()
    {
        return workerCountInComp+workerOutProject;
    }

}
