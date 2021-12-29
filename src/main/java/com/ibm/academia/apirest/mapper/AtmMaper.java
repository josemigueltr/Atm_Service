package com.ibm.academia.apirest.mapper;


import com.ibm.academia.apirest.models.dtos.AtmModelDto;
import com.ibm.academia.apirest.models.dtos.AtmResponseDto;

import java.util.List;

public class AtmMaper {

    public static AtmModelDto mapperAtmModelDto(List<String> data){
        AtmModelDto atmModel= AtmModelDto.builder()
                                      .address(data.get(4))
                                      .streets(data.get(6))
                                      .serviceHours(String.format("%s a %s",data.get(13),data.get(14)))
                                      .latitude(data.get(15))
                                      .longitude(data.get(16))
                                      .state(data.get(17))
                                      .sucursalType(data.get(19))
                                      .build();
        return  atmModel;

    }

    public static AtmResponseDto mapperAtmResponseDto(AtmModelDto atmModel){
        AtmResponseDto atmResponse= AtmResponseDto.builder()
                .address(atmModel.getAddress())
                .sucursalType(atmModel.getSucursalType())
                .serviceHours(atmModel.getServiceHours())
                .streets(atmModel.getStreets())
                .build();
        return  atmResponse;

    }

}
