package com.admin.domain.modle;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
public class XlProjectNameId implements Serializable {
    private int id;
    private String name;

}
