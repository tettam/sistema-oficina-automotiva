package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
  
}
