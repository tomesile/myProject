package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class BdProjectModle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToOne(targetEntity=ProjectBd.class)
    ProjectBd projectBd;
    @OneToMany(targetEntity=ProgressBd.class)
    List<ProgressBd> progressBd;

}
