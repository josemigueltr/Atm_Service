package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.dtos.AtmModelDto;
import com.ibm.academia.apirest.models.dtos.AtmResponseDto;

import java.util.List;

public interface AtmService {
    public List<AtmResponseDto> getNearServices(String state, String cp);
}
