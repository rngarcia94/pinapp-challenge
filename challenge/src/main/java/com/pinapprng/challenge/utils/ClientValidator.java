package com.pinapprng.challenge.utils;

import com.pinapprng.challenge.models.ClientDTO;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class ClientValidator {

  public void validateAgeAndBirthDate(ClientDTO client){
    if(calculateAge(client.getFechaDeNacimiento()) != client.getEdad()){
      throw new RuntimeException("Edad y fecha de naciemiento no concuerdan");
    }
  }

  private int calculateAge(LocalDate birthDate){
    return Period.between(birthDate, LocalDate.now()).getYears();
  }
}


