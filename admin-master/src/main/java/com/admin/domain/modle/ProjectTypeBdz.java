package com.admin.domain.modle;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

//工程类型(变电，土建，调试)
@Entity
public class ProjectTypeBdz implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;

    public int getId(){return id;}


    public String getName(){return name;}
    public void setName(String name1){name=name1;}
}
