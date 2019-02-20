package com.lambdaschool.javaorders.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "agents")
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentcode;

    private String agentname, workingarea, phone, country;
    private double commission;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
    private Set<Customers> customers;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
    private Set<Orders> orders;

    public Agents() {
    }
}
