package com.capgemini.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String sex;
    private String phone;
    private Boolean isAdmin;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
