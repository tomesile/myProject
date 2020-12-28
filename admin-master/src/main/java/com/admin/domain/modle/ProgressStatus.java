package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ProgressStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(targetEntity = TypeNameInGoingOn.class)
    private List<TypeNameInGoingOn> inList;
}
