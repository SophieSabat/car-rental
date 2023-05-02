package com.petproject.carrental.exeptions;

import com.petproject.carrental.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppExeption.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppExeption exeption) {
        return ResponseEntity.status(exeption.getCode())
                .body(ErrorDTO.builder().message(exeption.getMessage()).build());
    }
}
