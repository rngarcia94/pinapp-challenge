package com.pinapprng.challenge.controllers;

import com.pinapprng.challenge.models.ClientResponseDTO;
import com.pinapprng.challenge.services.ClientService;
import com.pinapprng.challenge.models.ClientDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/creacliente")
  public ResponseEntity<?> createClient(@RequestBody ClientDTO client){
    try {
      clientService.addClient(client);
      return ResponseEntity.ok("Cliente Creado");
    } catch (RuntimeException e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/listclientes")
  public ResponseEntity<List<ClientResponseDTO>> getClients(){
    return ResponseEntity.ok(clientService.getClients());
  }

  @GetMapping("/kpideclientes")
  public ResponseEntity<?> getKpi(){
    try{
      return ResponseEntity.ok(clientService.getStats());
    } catch (RuntimeException e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/create-client-list")
  public ResponseEntity<?> createClientList(@RequestBody List<ClientDTO> clients){
    try {
      clientService.addClients(clients);
      return ResponseEntity.ok("Clients Created Success");
    } catch (RuntimeException e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
