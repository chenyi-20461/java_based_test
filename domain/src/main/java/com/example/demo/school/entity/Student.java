package com.example.demo.school.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * catalog表示库名
 */
@Entity
@Table(name = "student", catalog = "demo")
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
