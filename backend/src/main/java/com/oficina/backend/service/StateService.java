package com.oficina.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.backend.model.entities.State;
import com.oficina.backend.repository.StateRepository;
import com.oficina.backend.service.exeptions.DatabaseException;
import com.oficina.backend.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StateService {
  
  @Autowired
  private StateRepository repository;

  public List<State> findAll(){
    return repository.findAll();
  }

  public State findById(Long id){
    Optional<State>  obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public State insert(State obj){
    return repository.saveAndFlush(obj);
  }

  public State update(State obj){
    try {
      return repository.saveAndFlush(obj);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(obj.getId());
    }
  }

  public void delete(Long id){
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      throw new DatabaseException(e.getMessage());
    }
  }
}
