package com.ibm.academia.apirest.services;


import com.ibm.academia.apirest.data.DummyData;
import com.ibm.academia.apirest.exceptions.exceptiontypes.BadRequestException;
import com.ibm.academia.apirest.models.dtos.AtmResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class AtmServiceImpTest {


    @Autowired
    AtmServiceImp atmServiceImp;


    /**
     * Metodo para probar que  PassionDao detecta correctamente las excepciones cuando se le proporcionan
     * datos incorrectos
     * Regresa True si se lanzo una BadRequestException
     */
    @Test
    @DisplayName("Test: Para corroborar la exception de los datos recibidos por el cliente son erroneos")
    void badRequestExceptionTest() {
        String state="Estado invalido";
        String cp="Codigo postal erroneo";
        assertThrows(BadRequestException.class, () -> atmServiceImp.getNearServices(state,cp));
    }

    /**
     * Metodo para probar que  AtmSetvice  hace correctamente obtiene los datos coreespondientes que se pidiaron
     * en la consulta realizada
     * Regresa True si la lista de sucursales obtenida es igual a la lista de sucursales esperada
     */
    @Test
    @DisplayName("Test: Para corroborar que al hacer una consulta se devuelven los datos esperados")
    void expectedValuesTest() {
        String state="ciudad de mexico";
        String cp="06000";
        List<AtmResponseDto> expectedValue= DummyData.datosPrueba1();
        List<AtmResponseDto> responseValues=atmServiceImp.getNearServices(state,cp);
        assertThat(expectedValue.size()== responseValues.size()).isTrue();
    }
}
