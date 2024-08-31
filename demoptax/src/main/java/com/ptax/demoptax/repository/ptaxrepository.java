package com.ptax.demoptax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptax.demoptax.model.ptaxModel;

@Repository

public interface ptaxrepository extends JpaRepository<ptaxModel, Integer> {
}
