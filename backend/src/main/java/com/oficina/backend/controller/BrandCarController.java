package com.oficina.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.backend.model.entities.BrandCar;
import com.oficina.backend.service.BrandCarService;



@RestController
@RequestMapping(value = "/brands")
public class BrandCarController {
  
  @Autowired
  private BrandCarService service;

  @GetMapping
  public ResponseEntity<List<BrandCar>> findAll(){
    List<BrandCar> list = service.findAll();
    return ResponseEntity.ok().body(list);
    
  }
}
