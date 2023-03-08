package com.oficina.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.BrandCar;
import com.oficina.backend.repository.BrandCarRepository;

@Service
public class BrandCarService {
  
  @Autowired
  private BrandCarRepository repository;

  public List<BrandCar> findAll(){
    return repository.findAll();
  }

  public BrandCar insert(BrandCar obj){
    return repository.saveAndFlush(obj);
  }

  public BrandCar update(BrandCar obj){
    return repository.saveAndFlush(obj);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }

}










