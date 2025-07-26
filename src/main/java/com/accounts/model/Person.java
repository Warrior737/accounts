package com.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="Person")
public class Person {

    @Id
    @JsonProperty
    private Integer personId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String Email;
    @JsonProperty
    private Integer phoneNumber;
    @JsonProperty
    private String address;
    @JsonProperty
    private Date dateOfBirth;


}
