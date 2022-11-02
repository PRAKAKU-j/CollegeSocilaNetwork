package com.capgemini.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "login_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    @Id
    private String userid;
    private String password;


}
