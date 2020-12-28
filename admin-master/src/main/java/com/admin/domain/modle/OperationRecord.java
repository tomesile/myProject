package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
public class OperationRecord  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(targetEntity=OperationType.class)
    private List<OperationType> typeList=new ArrayList<>();
    private String operationContent;
    @OneToOne(targetEntity=Users.class)
    private Users operationUser;
    private Date operationDate;
}
