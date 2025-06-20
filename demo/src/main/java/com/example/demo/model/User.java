package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
public class User {
  
  @Id
@GeneratedValue(strategy =GenerationType.AUTO)
  private Long Id;
  private String fullName;
 @NotBlank(message = "username is mandatory")
  private String username;
 @NotBlank(message = "eamil is mandatory")
 @Email(message="Email should be valid")
  private String email;

  private String phone;

  @NotBlank(message="role is mandatory")
  private String role;

  @CreationTimestamp
  private LocalDate createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
  @NotBlank(message = "password is mandatory")
 private String password;

  
}
