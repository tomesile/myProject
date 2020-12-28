package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class CompletedInWeek implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String one;
    private String two;
    private String three;

}
