package com.ibm.academia.apirest.models.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtmResponseDto {

    @JsonProperty("tipo_de_sucursal")
    private String sucursalType;
    @JsonProperty("horario_de_servicio")
    private String serviceHours;
    @JsonProperty("direccion")
    private String address;
    @JsonProperty("entre_calles")
    private String streets;

}
