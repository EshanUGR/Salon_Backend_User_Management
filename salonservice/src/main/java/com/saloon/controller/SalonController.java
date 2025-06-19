package com.saloon.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saloon.mapper.SalonMapper;
import com.saloon.model.Salon;
import com.saloon.payaload.SalonDTO;
import com.saloon.payaload.UserDTO;
import com.saloon.service.SaloonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

 private final  SaloonService saloonService;
// http://localhost:5002/api/salons

 @PatchMapping("/{id}")
 public ResponseEntity<SalonDTO> updateSalon(
  @PathVariable("id") Long salonId,
 @RequestBody SalonDTO salonDTO) throws Exception
 {

  UserDTO userDTO=new UserDTO();

  userDTO.setId(1L);

  Salon salon=saloonService.updateSalon(salonDTO, userDTO,salonId);
  SalonDTO salonDTO1=SalonMapper.mapToDTO(salon);
return ResponseEntity.ok(salonDTO1);

 }






 @GetMapping()
 public ResponseEntity<List<SalonDTO>> getSalons() throws Exception
 {



  List<Salon> salons=saloonService.getAllSalons();
 
List<SalonDTO> salonDTOs=salons.stream().map((salon)->
{
  SalonDTO salonDTO=SalonMapper.mapToDTO(salon);
  return salonDTO;
}).toList();

return ResponseEntity.ok(salonDTOs);
 }






 @GetMapping("/search")
 public ResponseEntity<List<SalonDTO>> searchSalons(@RequestParam("city") String city) throws Exception
 {



  List<Salon> salons=saloonService.searchSalonByCity(city);
 
List<SalonDTO> salonDTOs=salons.stream().map((salon)->
{
  SalonDTO salonDTO=SalonMapper.mapToDTO(salon);
  return salonDTO;
}).toList();

return ResponseEntity.ok(salonDTOs);
 }

















 @GetMapping("/{salonId}")
 public ResponseEntity<SalonDTO> getSalonById(

@PathVariable Long salonId

 ) throws Exception
 {

 
Salon salon=saloonService.getSalonById(salonId);

SalonDTO salonDTO=SalonMapper.mapToDTO(salon);

return ResponseEntity.ok(salonDTO);

 }















 @GetMapping("/owner")
 public ResponseEntity<SalonDTO> getSalonByOwnerId(

@PathVariable Long salonId

 ) throws Exception
 {

  UserDTO userDTO=new UserDTO();

  userDTO.setId(1L);
Salon salon=saloonService.getSalonByOwnerId(userDTO.getId());

SalonDTO salonDTO=SalonMapper.mapToDTO(salon);

return ResponseEntity.ok(salonDTO);

 }

























 @PostMapping
 public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO)
 {

  UserDTO userDTO=new UserDTO();

  userDTO.setId(1L);

  Salon salon=saloonService.createSalon(salonDTO, userDTO);
  SalonDTO salonDTO1=SalonMapper.mapToDTO(salon);
return ResponseEntity.ok(salonDTO1);

 }
  
}


