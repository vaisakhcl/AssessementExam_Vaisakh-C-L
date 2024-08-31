package com.ptax.demoptax.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // Correct import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptax.demoptax.model.ptaxModel;
import com.ptax.demoptax.service.ptaxService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/grievance")
public class ptaxController {

    @Autowired
    private ptaxService ptaxService;

    @Operation(summary = "Create a new Property tax ", description = "Endpoint to create a new Property tax with validated data.")
    @PostMapping
    // public ResponseEntity<Map<String, String>> createCitizen(@Valid @RequestBody ptaxModel ptax) { // Correct annotation
    //     Map<String, String> response = new HashMap<>();
    //     ptaxModel createdCitizen = ptaxService.saveCitizen(ptax);
    //     response.put("message", "PTAX created with ID: " + createdCitizen.getId());
    //     return ResponseEntity.status(HttpStatus.CREATED).body(response);
    // }

     public ResponseEntity<?> createemp(@Valid @RequestBody ptaxModel ptax) {
        Map<String, String> response = new HashMap<>();
        try {
            ptaxModel createemp = ptaxService.saveCitizen(ptax);
            response.put("message", "Ptax created with ID: " + createemp.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException ex) {
            response.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
       
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
       
        response.put("message", "Validation failed");
        response.put("errors", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}