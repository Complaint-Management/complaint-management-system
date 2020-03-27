package com.complainmanagement.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "Teacher")
    @Getter
    @Setter
    public class Teacher {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        @Column(name="name")
        private String name;

    }


