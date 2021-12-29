package com.ibm.academia.apirest.controller;

import com.ibm.academia.apirest.exceptions.exceptiontypes.ExceptionType;
import com.ibm.academia.apirest.models.dtos.AtmModelDto;
import com.ibm.academia.apirest.models.dtos.AtmResponseDto;
import com.ibm.academia.apirest.services.AtmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("atm/")
//Enpoint http://localhost:8081/atm/services/{Estado 0 delegacion}/{codigo postal}
public class AtmController {
    private AtmService atmService;

    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }


    /**
     * EndPoint que se encarga de regresar una lista de sucursales y ATM(cajeros automáticos) dada la información que proporcione
     * un cliente con respecto a su ubicación
     * @param state string que representara el estado o delegación en la que se encuentre el cliente.
     * @param cp    string que representa el codigo postal correspondiente a la ubicación del cliente.
     * @return Lista de sucursales y ATM(cajeros automáticos) mas cercanos dada la información proporcionada
     */
    @Operation(summary = "Regresa una lista de sucursales y ATM(cajeros automáticos) mas cercanos a una ubicación dada")
    @ApiResponse(responseCode = "200", description = "lista de sucursales y ATM(cajeros automáticos) mas cercanos a una ubicación",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AtmResponseDto.class)
            )})
    @GetMapping("/services/{state}/{cp}")
    private ResponseEntity<?> findNearServices(@PathVariable String state,
                                               @PathVariable String cp){
        log.info("RECIBIDA LA SIGUIENTE INFORMACION --> ESTADO/DELEGACION:{}  CODIGO_POSTAL}",state,cp);
        try {
            List<AtmResponseDto> results= atmService.getNearServices(state, cp);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (ExceptionType e){
            log.info("EXCEPCION OCURRIDA --> MENSAJE:{} , STATUS:{}", e.getMessage(),e.getStatus());
            throw  e;
        }
    }
}
