package com.admin.domain.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RtProjectBd implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private Date createDate;
    //@OneToOne(targetEntity=ProjectAllInfos.class)
   // private ProjectAllInfos projectAllInfos;
    //@OneToMany(targetEntity=SubCompany.class)
    // private List<SubCompany> subCompany;
    //一个线路工程对应多个进度
    private Date projectStartTime;
    // @Ignore
    private Date projectEndTime;

    private String managerName;
    private String phoneNum;

    private String comName;
}
