package com.ibm.academia.apirest.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtmModelDto {
    private String address;
    private String streets;
    private String serviceHours;
    private String latitude;
    private String longitude;
    private String state;
    private String sucursalType;
}
