package com.capgemini.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "register_table")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String name;
    @Id
    private String userId;
    private String email;
    private String phone;
    private String password;
    private String cpassword;
    private String gender;
}
