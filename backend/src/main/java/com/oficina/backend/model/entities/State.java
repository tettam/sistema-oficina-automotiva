package com.oficina.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_state")
@Data
public class State {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "É necessário digitar o nome do estado")
  @Size(min = 2)
  private String name;
  @NotBlank(message = "É necessário digitar a sigla do estado")
  private String acronym;

  @JsonIgnore
  @OneToMany(mappedBy = "state")
  List<City> listCitys = new ArrayList<>();
}
