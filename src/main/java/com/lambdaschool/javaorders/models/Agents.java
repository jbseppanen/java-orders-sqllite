package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Data
//@NoArgsConstructor
@Entity
@Table(name = "agents")
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentcode;

    private String agentname, workingarea, phone, country;
    private double commission;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
    private Set<Customers> customers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
    private Set<Orders> orders;

    public Agents() {
    }
}
