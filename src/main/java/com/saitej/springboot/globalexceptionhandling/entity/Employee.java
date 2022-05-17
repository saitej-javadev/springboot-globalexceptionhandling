package com.saitej.springboot.globalexceptionhandling.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private Double salary;
        }
