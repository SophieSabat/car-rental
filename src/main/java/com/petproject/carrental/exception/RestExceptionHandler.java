package com.petproject.carrental.exception;

import com.petproject.carrental.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException exeption) {
        return ResponseEntity.status(exeption.getCode())
                .body(ErrorDTO.builder().message(exeption.getMessage()).build());
    }
}
