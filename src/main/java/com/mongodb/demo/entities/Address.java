package com.mongodb.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Address {
    @Id
    private String id;
    private String avenue;
    private String street;
    private Integer apartNo;
    private String city;
    private String postCode;

    private Employee employee;

    public Address(String avenue, String street, Integer apartNo, String city, String postCode) {
        this.avenue = avenue;
        this.street = street;
        this.apartNo = apartNo;
        this.city = city;
        this.postCode = postCode;
    }


}
