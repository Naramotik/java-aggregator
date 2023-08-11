package ru.vlsu.javaaggregatorapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vlsu.javaaggregatorapp.exception.GameNotFoundException;
import ru.vlsu.javaaggregatorapp.exception.LinkNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LinkExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LinkNotFoundException.class)
    public Map<String, String> handleLinkException(LinkNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
}
