package com.petproject.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passportNumber;
    private String token;

    public UserDTO(String password, String email, String firstName, String lastName) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDTO(String password, String email, String firstName, String lastName, String phoneNumber, String passportNumber) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
    }
}
