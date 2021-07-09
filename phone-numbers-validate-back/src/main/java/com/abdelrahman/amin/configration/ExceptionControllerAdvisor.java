package com.abdelrahman.amin.configration;

import com.abdelrahman.amin.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvisor {

    //TODO:Handel Each exception and response with descriptive error page
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handelAllExceptions(Exception e, HttpServletRequest request) {
        ErrorResponse errorResponse
                = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), LocalDateTime.now(), request.getServletPath());
        return ResponseEntity.ok(errorResponse);
    }
}
