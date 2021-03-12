package com.example.demo.student.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "学生表")
@Data
@Builder
public class Student {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String sid;

    @Column
    private Integer score;

}
