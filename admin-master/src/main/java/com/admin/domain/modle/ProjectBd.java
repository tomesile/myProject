package com.admin.domain.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ProjectBd implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private Date createDate;
    @OneToOne(targetEntity=ProjectAllInfos.class)
    private ProjectAllInfos projectAllInfos;
    //@OneToMany(targetEntity=SubCompany.class)
   // private List<SubCompany> subCompany;
    //一个线路工程对应多个进度
    @JsonBackReference
    @OneToMany(targetEntity= ProgressBd.class)
   private List<ProgressBd> progressBdList=new ArrayList<>();

   @JsonBackReference
    @OneToMany(targetEntity = TitleInThisWeek.class,cascade = CascadeType.ALL)
    private List<TitleInThisWeek> titleInThisWeek=new ArrayList<>();
    @Override
    public String toString() {
        return "ProjectBD";
    }
}
