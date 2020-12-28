package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
//工程类型类
@Data
@Entity
public class ProjectType implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String typeName;
}
