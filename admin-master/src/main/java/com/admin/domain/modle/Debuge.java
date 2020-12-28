package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Debuge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String allDebug;
    private String nextDebug;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showIndex;
    private Date createDate;
}
