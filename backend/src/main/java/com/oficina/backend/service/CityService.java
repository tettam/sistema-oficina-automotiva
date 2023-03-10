package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.City;
import com.oficina.backend.repository.CityRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
  
  @Autowired
  private CityRepository repository;

  public List<City> findAll(){
    return repository.findAll();
  }

  public City findById(Long id){
    Optional<City>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public City insert(City obj){
    return repository.saveAndFlush(obj);
  }

  public City update(Long id, City obj){
    try {
      City entity = repository.getReferenceById(id);
      updateCity(entity, obj);
      return repository.saveAndFlush(entity);

    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  public void delete(Long id){
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public void updateCity(City entity, City obj){
    entity.setName(obj.getName());
  }
}
