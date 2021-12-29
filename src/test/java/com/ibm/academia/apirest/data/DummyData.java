package com.ibm.academia.apirest.data;

import com.ibm.academia.apirest.models.dtos.AtmResponseDto;

import java.util.List;

public class DummyData {
        public  static List<AtmResponseDto> datosPrueba1(){

            AtmResponseDto atm1=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("09:00 a 16:00").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("Sucursal Automatica").build();

            AtmResponseDto atm2=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours( "24x7 a 24x7").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("Sucursal Automatica").build();

            AtmResponseDto atm3=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("09:00 a 16:00").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("ATM").build();

            AtmResponseDto atm4=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("09:00 a 16:00").streets("Venustiano Carranza").sucursalType("AFORE").build();

            AtmResponseDto atm5=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours( "24x7 a 24x7").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("ATM").build();

            AtmResponseDto atm6=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("09:00 a 16:00").streets("Gante y Bolivar").sucursalType("Ejecutivo Priority").build();

            AtmResponseDto atm7=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("24x7 a 24x7").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("ATM").build();

            AtmResponseDto atm8=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("24x7 a 24x7").streets("7 Eleven").sucursalType("ATM").build();

            AtmResponseDto atm9=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("00:00 a 00:00").streets("Venustiano Carranza y 16 De Septiembre").sucursalType("ATM").build();

            AtmResponseDto atm10=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours( "09:00 a 16:00").streets( "Gante y Bolivar").sucursalType("Sucursal").build();

            AtmResponseDto atm11=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("09:00 a 16:00").streets("Venustiano Carranza e Isabel La Católica").sucursalType("Banca Patrimonial").build();

            AtmResponseDto atm12=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours( "09:00 a 16:00").streets( "Venustiano Carranza y 16 De Septiembre").sucursalType("Sucursal").build();

            AtmResponseDto atm13=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("24x7 a 24x7").streets("Plaza Mixcalco").sucursalType("ATM").build();

            AtmResponseDto atm14=AtmResponseDto.builder().address("Col. Centro, Cuauhtémoc, C.P. 06000, Ciudad de México")
                    .serviceHours("24x7 a 24x7").streets("Gante y Bolivar").sucursalType("ATM").build();

            return  List.of(atm1,atm2,atm3,atm4,atm5,atm6,atm7,atm8,atm9,atm10,atm11,atm12,atm13,atm14);


        }

}
