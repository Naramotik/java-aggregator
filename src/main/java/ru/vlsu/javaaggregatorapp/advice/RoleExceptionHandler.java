package ru.vlsu.javaaggregatorapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vlsu.javaaggregatorapp.exception.LinkNotFoundException;
import ru.vlsu.javaaggregatorapp.exception.RoleNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RoleExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleNotFoundException.class)
    public Map<String, String> handleRoleException(RoleNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
}
