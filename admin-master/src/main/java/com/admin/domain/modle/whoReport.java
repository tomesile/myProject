package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
public class whoReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne(targetEntity = Users.class)
    private Users user;
}
