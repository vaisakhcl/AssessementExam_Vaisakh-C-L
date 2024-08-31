package com.ptax.demoptax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptax.demoptax.model.ptaxModel;
import com.ptax.demoptax.repository.ptaxrepository;

@Service
public class ptaxService {
     @Autowired
    private ptaxrepository ptaxRepository;
 
    public ptaxModel saveCitizen(ptaxModel ptax) {
        return ptaxRepository.save(ptax);
    }
}
