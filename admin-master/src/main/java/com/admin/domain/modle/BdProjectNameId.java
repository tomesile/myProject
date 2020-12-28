package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;

@Data
public class BdProjectNameId implements Serializable {
    private int id;
    private String name;
}
