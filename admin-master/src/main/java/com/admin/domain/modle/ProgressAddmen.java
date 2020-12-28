package com.admin.domain.modle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.io.Serializable;
//进度信息填报人类
@Entity
public class ProgressAddmen implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){return id;}
    public void setName(String progressName){name=progressName;}
}
