package com.mii.clinetapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Long department;
    private User user;
    public List<Project> projects;

    public Employee(String firstName, String lastName, String email, String address, Long department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.department = department;
    }
}
