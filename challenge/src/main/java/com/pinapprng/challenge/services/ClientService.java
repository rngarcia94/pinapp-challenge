package com.pinapprng.challenge.services;

import com.pinapprng.challenge.models.ClientDTO;
import com.pinapprng.challenge.models.ClientResponseDTO;
import com.pinapprng.challenge.models.KpiDTO;
import com.pinapprng.challenge.utils.ClientValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  private static final int ESPERANZA_DE_VIDA = 73;

  private final ClientValidator clientValidator;

  List<ClientResponseDTO> clientDTOList = new ArrayList<>();

  public ClientService(ClientValidator clientValidator) {
    this.clientValidator = clientValidator;
  }

  public void addClient(ClientDTO client){
    clientValidator.validateAgeAndBirthDate(client);
    ClientResponseDTO responseDTO = ClientResponseDTO.builder()
        .nombre(client.getNombre())
        .apellido(client.getApellido())
        .edad(client.getEdad())
        .fechaDeNacimiento(client.getFechaDeNacimiento())
        .fechaProbableDeMuerte(calculateDeathDate(client))
        .build();
    clientDTOList.add(responseDTO);
  }

  public void addClients(List<ClientDTO> clients){
    clients.forEach(this::addClient);
  }

  public List<ClientResponseDTO> getClients(){
    return clientDTOList;
  }

  public KpiDTO getStats(){
    checkEmpty();
    return KpiDTO.builder()
        .promedioDeEdad(calculateAgeMean())
        .desviacionEstandar(calculateSD())
        .build();
  }

  private int calculateSum(){
    int sum = 0;
    for (ClientDTO clientDTO : clientDTOList) {
      sum += clientDTO.getEdad();
    }
    return sum;
  }

  private double calculateAgeMean(){
      return (double) calculateSum()/clientDTOList.size();
  }

  private double calculateSD() {
    double sd = 0.0;
    double mean = calculateAgeMean();
    for (ClientDTO clientDTO : clientDTOList) {
      sd += Math.pow(clientDTO.getEdad() - mean, 2);
    }
    return Math.sqrt(sd/clientDTOList.size());
  }

  private LocalDate calculateDeathDate(ClientDTO client){
    return client.getFechaDeNacimiento().plusYears(ESPERANZA_DE_VIDA);
  }

  private void checkEmpty(){
    if(clientDTOList.isEmpty()){
      throw new RuntimeException("Lista de clientes vacia!");
    }
  }
}
