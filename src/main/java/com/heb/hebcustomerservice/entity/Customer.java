package com.heb.hebcustomerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    @NotBlank(message = "Invalid customer Customer ID")
    private UUID customerId;

    @Column(name= "first_name")
    @NotBlank(message = "Invalid First Name")
    private String firstName;

    @Column(name= "last_name")
    @NotBlank(message = "Invalid Last Name")
    private String lastName;

    @Column(name= "email_address")
    @Email(message = "Invalid email Address")
    private String emailAddress;

    @Column(name= "city")
    @NotBlank(message = "Invalid City ")
    private String city;

    @Column(name= "state")
    @NotBlank(message = "Invalid state")
    private String state;

    @Column(name= "zip")
    @NotBlank(message = "Invalid zip code")
    @Size(max = 6)
    private String zip;

}
