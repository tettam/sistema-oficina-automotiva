package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.BrandCar;
import com.oficina.backend.repository.BrandCarRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BrandCarService {
  
  @Autowired
  private BrandCarRepository repository;

  public List<BrandCar> findAll(){
    return repository.findAll();
  }

  public BrandCar findById(Long id){
    Optional<BrandCar>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public BrandCar insert(BrandCar obj){
    return repository.saveAndFlush(obj);
  }

  public BrandCar update(Long id, BrandCar obj){
    try {
      BrandCar entity = repository.getReferenceById(id);
      updateBrandCar(entity, obj);
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

  public void updateBrandCar(BrandCar entity, BrandCar obj){
    entity.setName(obj.getName());
  }
}










