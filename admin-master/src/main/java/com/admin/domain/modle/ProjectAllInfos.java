package com.admin.domain.modle;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
public class ProjectAllInfos implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
  //  @Ignore
    private Date projectStartTime;
   // @Ignore
    private Date projectEndTime;

    @OneToMany(targetEntity = TypeWork.class,cascade=CascadeType.ALL)
    private List<TypeWork> typeWorkList=new ArrayList<>();

    @OneToMany(targetEntity = SubCompany.class ,cascade=CascadeType.ALL)
    private List<SubCompany> subCompany=new ArrayList<>();

}
