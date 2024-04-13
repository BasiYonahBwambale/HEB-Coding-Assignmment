package com.heb.hebcustomerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    private UUID customerId;
    @Column(name= "first_name")
    private String first_name;
    @Column(name= "last_name")
    private String last_name;
    @Column(name= "email_address")
    private String email_address;
    @Column(name= "city")
    private String city;
    @Column(name= "state")
    private String state;
    @Column(name= "zip")
    private String zip;

}
