package com.saloon.mapper;

import com.saloon.model.Salon;
import com.saloon.payaload.SalonDTO;

public class SalonMapper {
  

  public static  SalonDTO mapToDTO(Salon salon)
  {
SalonDTO salonDTO=new SalonDTO();
salonDTO.setId(salon.getId());
salonDTO.setName(salon.getName());
salonDTO.setAddress(salon.getAddress());
salonDTO.setCity(salon.getCity());
salonDTO.setImages(salon.getImages());
salonDTO.setClosetime(salon.getClosetime());

salonDTO.setOpenTime(salon.getOpenTime());
salonDTO.setPhoneNumber(salon.getPhoneNumber());
salonDTO.setOwnerId(salon.getOwnerId());

return salonDTO;


  }
}
