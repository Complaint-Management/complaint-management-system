package com.complainmanagement.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="rollNumber")
    private Integer rollNumber;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="mentorId")
    private Integer mentorId;
}
