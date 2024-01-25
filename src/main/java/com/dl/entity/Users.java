package com.dl.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private Long phone;
    private String userEmail;
    private String password;
    private boolean isActive = true;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    @JsonIgnore
    private Set<Roles> assignRoles;

    @ManyToMany
    @JoinTable(name = "user_stores_details", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "storeId"))
    @JsonIgnore
    private Set<Stores> assignStores;
}
