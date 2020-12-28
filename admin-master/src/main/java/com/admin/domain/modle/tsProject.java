package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class tsProject implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;
    private String projectName;
}
