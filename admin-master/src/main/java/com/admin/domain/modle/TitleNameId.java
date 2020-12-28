package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;

@Data
public class TitleNameId implements Serializable {
    private int id;
    private String name;
}
