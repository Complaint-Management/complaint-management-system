package com.complainmanagement.pojo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="rollNumber")
    private Integer rollNumber;

    @Column(name="name")
    private String name;

    @Column(name="complain")
    private String complain;

    @Column(name="remark")
    private String remark;

    @Column(name="resolved")
    private int resolved;


}
