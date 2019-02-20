package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity, workingarea, custcountry, grade, phone;
    private double openingamt, receiveamt, paymentamt, outstandingamt;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agent;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customers")
    @JsonIgnore
    private Set<Orders> orders;

    public Customers() {
    }
}
