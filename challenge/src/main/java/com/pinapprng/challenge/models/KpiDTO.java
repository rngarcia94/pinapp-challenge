package com.pinapprng.challenge.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class KpiDTO {

  private double promedioDeEdad;
  private double desviacionEstandar;
}
