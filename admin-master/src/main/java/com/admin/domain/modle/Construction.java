package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Construction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String allConstruction;
    private String nextStageConstruction;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showIndex;
    private Date createDate;
}
