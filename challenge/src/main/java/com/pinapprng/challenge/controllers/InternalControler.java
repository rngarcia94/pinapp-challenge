package com.pinapprng.challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalControler {


  @GetMapping("/ping")
  public ResponseEntity<String> healthCheck(){
    return ResponseEntity.ok("pong");
  }
}
