package com.newyear.api.LoginNewYear.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
