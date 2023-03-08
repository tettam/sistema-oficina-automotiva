package com.oficina.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_city")
@Data
public class City {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "É necessário o cadastro do nome da cidade")
  @Size(min = 2)
  private String name;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "state_id")
  private State state;

  @OneToMany(mappedBy = "city")
  private List<Client> listClient = new ArrayList<>();
}
