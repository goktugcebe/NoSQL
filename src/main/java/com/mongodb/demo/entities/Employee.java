package com.mongodb.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employee {
    @Id
    private long id;


    private String name;


    private double salary;

    private Address address;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}