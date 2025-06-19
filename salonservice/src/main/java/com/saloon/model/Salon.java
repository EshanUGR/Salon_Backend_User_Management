package com.saloon.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Salon {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(nullable = false)
  private String name;


  @ElementCollection
  private List<String> images;


  @Column(nullable = false)
  private String address;


  @Column(nullable = false)
  private String phoneNumber;

@Column(nullable = false)
private String email;


@Column(nullable = false)
private String city;


@Column(nullable = false)
private Long ownerId;




@Column(nullable = false)
private LocalTime  openTime;
  

@Column(nullable = false)
private LocalTime closetime;



}
