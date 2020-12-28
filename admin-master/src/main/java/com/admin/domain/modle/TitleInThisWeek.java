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
import javax.persistence.GenerationType;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class TitleInThisWeek implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private int projectId;
    private int showIndex;//前台展示的顺序
    @JsonBackReference
    @OneToMany(targetEntity = XlProgress.class)
    private List<XlProgress> xlList=new ArrayList();
    @JsonBackReference
    @OneToMany(targetEntity = ProgressBd.class,cascade = CascadeType.ALL)

    private List<ProgressBd> bdList=new ArrayList();
    private int projectTypeId;
    private Date createDate;
    @Override
    public String toString() {
        return "TitleInThisWeek";
    }
}
