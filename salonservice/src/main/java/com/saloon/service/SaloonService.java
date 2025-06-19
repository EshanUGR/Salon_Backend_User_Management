package com.saloon.service;

import java.util.List;

import com.saloon.model.Salon;
import com.saloon.payaload.SalonDTO;
import com.saloon.payaload.UserDTO;

public interface SaloonService {

Salon createSalon(SalonDTO salon,UserDTO user);
Salon updateSalon(SalonDTO salon,UserDTO user,Long salonId) throws Exception;


List<Salon> getAllSalons();

Salon getSalonById(Long salonId) throws Exception;

Salon getSalonByOwnerId(Long ownerId);

List<Salon> searchSalonByCity(String city);




  
} 
