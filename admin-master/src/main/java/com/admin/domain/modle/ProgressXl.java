package com.admin.domain.modle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

//进度线路类
@Entity
public class ProgressXl  {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float completedProgerss;
    private String worksNextWeek;
    private String questionInFact;
    private String otherInfos;
    private Date time;
    private Timestamp createDate;
    private int progressCreater;
    private int progressAddmen;


    public int getId(){return id;}
    public void setId(int id1){id=id1;}

    public float getCompletedProgerss(){return completedProgerss;}
    public void setCompletedProgerss(float completedProgerss1){completedProgerss=completedProgerss1;}

    public String getWorksNextWeek(){return worksNextWeek;}
    public void setWorksNextWeek(String worksNextWeek1){worksNextWeek=worksNextWeek1;}

    public String getQuestionInFact(){return questionInFact;}
    public void setQuestionInFact(String questionInFact1){questionInFact=questionInFact1;}

    public String getOtherInfos(){return otherInfos;}
    public void setOtherInfos(String otherInfos1){otherInfos=otherInfos1;}

    public Date getTime(){return time;}
    public void setTime(Date time1){time=time1;}

    public int getProgressCreater() {
        return progressCreater;
    }
    public void setProgressCreater(int progressCreater1){progressCreater=progressCreater1;}

    public int getProgressAddmen(){return progressAddmen;}
    public void setProgressAddmen(int progressAddmen1){progressAddmen=progressAddmen1;}

}
