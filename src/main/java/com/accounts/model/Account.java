package com.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="Account")
public class Account {

    @Id
    @JsonProperty
    private Long accountId;
    @JsonProperty
    private Long personId;
    @JsonProperty
    private Integer accountNumber;
    @JsonProperty
    private String accountType;
    @JsonProperty
    private String accountStatus;
    @JsonProperty
    private Date dateOpened;
    @JsonProperty
    private Date dateClosed;

}
