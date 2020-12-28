package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
//添加信息类型类
@Data
@Entity
public class AddInfoType implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String other;
}
