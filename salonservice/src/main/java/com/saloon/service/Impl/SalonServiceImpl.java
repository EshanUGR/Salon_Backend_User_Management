package com.saloon.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saloon.model.Salon;
import com.saloon.payaload.SalonDTO;
import com.saloon.payaload.UserDTO;
import com.saloon.repository.SalonRepository;
import com.saloon.service.SaloonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SaloonService {
  private final SalonRepository salonRepository;


  @Override
  public Salon createSalon(SalonDTO req, UserDTO user) {
    Salon salon=new Salon();
    salon.setName(req.getName());
    salon.setAddress(req.getAddress());
    salon.setEmail(req.getEmail());
    salon.setCity(req.getCity());
    salon.setImages(req.getImages());
    salon.setOwnerId(user.getId());
    salon.setOpenTime(req.getOpenTime());
    salon.setClosetime(req.getClosetime());
    salon.setPhoneNumber(req.getPhoneNumber());

  return salonRepository.save(salon);

  }

  @Override
  public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception{

Salon existingSalon=salonRepository.findById(salonId).orElse(null);

if(existingSalon!=null  && salon.getOwnerId().equals(user.getId()))
{
existingSalon.setCity(salon.getCity());
existingSalon.setName(salon.getName());
existingSalon.setAddress(salon.getAddress());
existingSalon.setEmail(salon.getEmail());
existingSalon.setImages(salon.getImages());
existingSalon.setPhoneNumber(salon.getPhoneNumber());
existingSalon.setOpenTime(salon.getOpenTime());
existingSalon.setClosetime(salon.getClosetime());
existingSalon.setOwnerId(user.getId());
return salonRepository.save(existingSalon);
}



    throw new Exception("salon not found");
  }

  @Override
  public List<Salon> getAllSalons() {
    return salonRepository.findAll();
  }

  @Override
  public Salon getSalonById(Long salonId) throws Exception {



   Salon salon= salonRepository.findById(salonId).orElse(null);

   if(salon==null)
   {
    throw new Exception("salon not found");
   }
   return salon;
  }
  @Override
  public Salon getSalonByOwnerId(Long ownerId) {
    return salonRepository.findByOwnerId(ownerId);
  }

  @Override
  public List<Salon> searchSalonByCity(String city) {
    return salonRepository.searchSalons(city);
  }
  
}
