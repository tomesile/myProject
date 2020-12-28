package com.admin.domain.modle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ProgressBd implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = Construction.class)
    private Construction construction;
    @OneToOne(targetEntity = Elec.class)
    private Elec elec;
    @OneToOne(targetEntity = Debuge.class)
    private Debuge debuge;
    private Date createDate;

    @ManyToOne(targetEntity=ProjectBd.class,cascade = CascadeType.ALL)
    @JsonBackReference //解决循环依赖
    private ProjectBd projectBd;
    private int indexInWeek;
    @JsonBackReference
    @ManyToOne(targetEntity = TitleInThisWeek.class,cascade = CascadeType.ALL)
    private TitleInThisWeek titleInThisWeek;

    @Override
    public String toString() {
        return "ProgressBD";
    }

    }
