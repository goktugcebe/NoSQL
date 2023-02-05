package com.mongodb.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "avenue")
    private String avenue;

    @Column(name = "street")
    private String street;

    @Column(name = "apartNo")
    private Integer apartNo;

    private String city;

    private String postCode;

    public Address(String avenue, String street, Integer apartNo, String city, String postCode) {
        this.avenue = avenue;
        this.street = street;
        this.apartNo = apartNo;
        this.city = city;
        this.postCode = postCode;
    }

    @OneToOne
    private Employee employee;
}
