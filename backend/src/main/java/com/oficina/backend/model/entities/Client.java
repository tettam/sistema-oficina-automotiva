package com.oficina.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tb_client")
@Data
public class Client {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotBlank(message = "O nome é obrigatório!")
  @Length(min = 2, max = 50, message = "O nome deve ter no mínimo {min} caracteres")
  private String name;
  @Email
  private String email;
  private String phone;
  private String address;
  private String zipCode;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @JsonIgnore
  @OneToMany(mappedBy = "client")
  private List<Vehicle> listVehicle = new ArrayList<>();
}
