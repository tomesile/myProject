package com.admin.domain.modle;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//进度创建人类
@Entity
public class ProgressCreater implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    public int getId(){return id;}
    public String getName(){return name;}
    public void setName(String createName){name=createName;}
}
