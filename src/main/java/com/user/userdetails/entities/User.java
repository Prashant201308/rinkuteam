package com.user.userdetails.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="users")
@Data
public class User {

    //increment id auto
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String email;
}
