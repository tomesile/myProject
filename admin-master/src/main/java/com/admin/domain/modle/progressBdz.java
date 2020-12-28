package com.admin.domain.modle;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
//进度类
@Entity
public class progressBdz implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String type;
    private String content;
    private String typeName;
    private Date time;
    private int createUserId;
    private int infoAddMenId;

    public int getId(){return id;}
    public void setId(int id1){id=id1;}

    public String getType(){return type;}
    public void setType(String progressType){type=progressType;}

    public String getContent(){return content;}
    public void setContent(String contentInfo){content=contentInfo;}

    public String getTypeName(){return typeName;}
    public void setTypeName(String type){typeName=type;}

    public Date getTime(){return time;}

    public int getCreateUserId(){return createUserId;}
    public void setCreateUserId(int createUserId0){createUserId=createUserId0;}

    public int getInfoAddMenId(){return infoAddMenId;}
    public void setInfoAddMenId(int infoAddMenId1){infoAddMenId=infoAddMenId1;}
}
