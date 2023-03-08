package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {
  
}
