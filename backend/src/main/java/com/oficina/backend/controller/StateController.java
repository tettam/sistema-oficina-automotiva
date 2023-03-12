package com.oficina.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.backend.model.entities.State;
import com.oficina.backend.service.StateService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/states")
public class StateController {
  
  @Autowired
  private StateService service;

  @GetMapping
  public ResponseEntity<List<State>> findAll(){
    List<State> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<State> findById(@PathVariable Long id){
    State obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<State> add(@RequestBody @Valid State obj){
    State object = service.insert(obj);
    return ResponseEntity.created(null).body(object);
  }

  @PutMapping
  public ResponseEntity<State> update(@RequestBody State obj){
    service.update(obj);
    return ResponseEntity.ok().body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
