package com.admin.domain.modle;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class TypeWork implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

  //  @OneToOne(targetEntity=Typews.class)
   // private Typews tYpe;

    private String managerName;
    private String phoneNum;

}
