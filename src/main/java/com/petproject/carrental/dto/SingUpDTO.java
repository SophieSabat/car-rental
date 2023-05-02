package com.petproject.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SingUpDTO {

    private String firstName;
    private String lastName;
    private String email;
    private char[] password;
}
