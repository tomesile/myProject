package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

//工程类（变电土建调试）
@Data
@Entity
public class ProjectBzd  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;

    //一个变电工程属于一个工程项目
    @OneToOne(targetEntity=ProjectClass.class)
    private ProjectClass root=new ProjectClass();

    @OneToMany(targetEntity=ProjectTypeBdz.class)
    private List<ProjectTypeBdz> projectTypeBdzList=new ArrayList<>();

    @OneToMany(targetEntity=progressBdz.class)
    private List<progressBdz> progressBdzList=new ArrayList<>();



}
