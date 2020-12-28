package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ProjectProgress {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int projectId;
    private int progressId;

    @OneToMany(targetEntity=ProgressXl.class)
    List<ProgressXl> progressXlList=new ArrayList<>();

    @OneToOne(targetEntity=ProjectXl.class)
    ProjectXl projectXl=new ProjectXl();

    @OneToOne(targetEntity=ProjectBzd.class)
    ProjectBzd projectBzd=new ProjectBzd();

}
