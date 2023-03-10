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

import com.oficina.backend.model.entities.City;
import com.oficina.backend.service.CityService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/cities")
public class CityController {
  
  @Autowired
  private CityService service;

  @GetMapping
  public ResponseEntity<List<City>> findAll(){
    List<City> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<City> findById(@PathVariable Long id){
    City obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<City> add(@RequestBody @Valid City obj){
    City object = service.insert(obj);
    return ResponseEntity.created(null).body(object);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<City> update(@PathVariable Long id,@RequestBody City obj){
    City object = service.update(id, obj);
    return ResponseEntity.ok().body(object);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
