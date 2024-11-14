package com.javawebcar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @OneToMany(targetEntity = Car.class)
    @JoinColumn(name = "userID")
    private Set<Car> cars;

    private String name;
    private String username;
    private String password;
    private String role;
    private String email;   // Thêm email
    private String phone;   // Thêm phone

    public User() {
    }

    public User(Long userId, String name, String username, String password, String role, String email, String phone) {
        this.userID = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String username, String password, String role, String email, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public Long getUserId() {
        return userID;
    }

    public void setUserId(Long userId) {
        this.userID = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
