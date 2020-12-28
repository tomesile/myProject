package com.admin.domain.modle;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
public class AddInfoMember implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private boolean isAdmin;
    private String toUserId;
    //一个信息填报人员对应一个用户
  //  @OneToOne(targetEntity=User.class)
   // private User user=new User();
}
