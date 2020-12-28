package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.admin.domain.modle.CompletedInWeek;
@Data
@Entity
public class XlProgress implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private Date createDate;
    private String statusContent;//后来修改为了总体填入进度总情况的形式
    @OneToOne(targetEntity = CompletedInWeek.class)
    private CompletedInWeek completedInWeek;
    private String planForNextWeek;
    private String questions;
    private String infos;
    @OneToOne(targetEntity= whoReport.class)
    private whoReport whoReport;//填报人
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int descIndex;//用来表示在前台显示的时候的顺序,序号越大越在前面显示
    @ManyToOne(targetEntity=ProjectXl.class)
    private ProjectXl projectXl;
    private int indexInWeek;
    @ManyToOne(targetEntity = TitleInThisWeek.class)
    private TitleInThisWeek titleInThisWeek;
    @Override
    public String toString() {
        return "XlProgress";
    }
}
