package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.exceptions.exceptiontypes.BadRequestException;
import com.ibm.academia.apirest.exceptions.exceptiontypes.InternalServerException;
import com.ibm.academia.apirest.mapper.AtmMaper;
import com.ibm.academia.apirest.models.dtos.AtmModelDto;
import com.ibm.academia.apirest.models.dtos.AtmResponseDto;
import com.ibm.academia.apirest.utils.NormalizeStrings;
import com.ibm.academia.apirest.utils.ParseDataAtm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AtmServiceImp implements AtmService{

    @Autowired
    private RestTemplate banamexClient;

    public List<AtmResponseDto> getNearServices(String state, String cp){
        String data;
        try {
            data=banamexClient.getForObject("https://www.banamex.com/localizador/jsonP/json5.json",String.class);
        }catch (Exception e){
            log.info("EXCEPCION OCURRIDA AL INTENTAR OBTENER LOS DATOS--> MENSAJE:{}", e.getMessage());
            throw new InternalServerException(HttpStatus.INTERNAL_SERVER_ERROR,"Ocurrio un error al obtener la informacion");
        }
        ParseDataAtm parseDataAtm=new ParseDataAtm(data);
        List<AtmModelDto> atmData=parseDataAtm.getParsedData().stream()
                .map(AtmMaper::mapperAtmModelDto).collect(Collectors.toList());
        log.info("INFORMACION CORRECTAMENTE OBTENIDA Y TRANSFORMADA");
        List<AtmResponseDto> atmDatafilter=filterAtmData(atmData,state,cp);
        if(atmDatafilter.isEmpty())
            throw new BadRequestException(HttpStatus.BAD_REQUEST,"Los datos ingresados son incorrectos");
        return atmDatafilter;
    }


    private List<AtmResponseDto> filterAtmData(List<AtmModelDto> atmModels,String state,String cp){
            String stateNorm= NormalizeStrings.cleanString(state);

        List<AtmModelDto> atmModelsFilter= atmModels.stream().filter(atmModelDto ->
               (NormalizeStrings.cleanString(atmModelDto.getState()).contains(stateNorm) ||
                NormalizeStrings.cleanString(atmModelDto.getAddress()).contains(stateNorm)) &&
                atmModelDto.getAddress().contains(cp)).collect(Collectors.toList());

        List<AtmResponseDto> atmResponseDtos=atmModelsFilter.stream()
                .map(AtmMaper::mapperAtmResponseDto).collect(Collectors.toList());
    return  atmResponseDtos;
    }

}
