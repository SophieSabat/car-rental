package com.petproject.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ErrorDTO {

    private String message;


}
