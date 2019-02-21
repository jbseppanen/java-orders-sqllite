package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordnum;

    private double ordamount, advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
//    @JsonIgnore
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
//    @JsonIgnore
    private Agents agent;

    private String orddescription;

    public Orders() {
    }
}
