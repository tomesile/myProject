package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@Entity
public class TypeNameInGoingOn implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String listTtypeNameInGoOn;
    private String content;
    private int conectToStatus;//关联到进度情况种类
}
