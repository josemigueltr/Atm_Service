package com.ibm.academia.apirest.utils;

import java.text.Normalizer;


public class NormalizeStrings {

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        texto=texto.toLowerCase();
        return texto;
    }
}
