package com.ibm.academia.apirest.utils;

import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class ParseDataAtm {
    private String data;

    public List<List<String>>  getParsedData(){
        Set<List<String>> matches = new HashSet<>();
        Matcher match = Pattern.compile("\\[.*?\\]").matcher(this.data);
        while (match.find()) {
            List<String> dataWords =new ArrayList<>();
            String wordFound= match.group();
            Matcher words = Pattern.compile("\\\".*?\\\"").matcher(wordFound);
            while (words.find()) {
                byte[] bytes = words.group().getBytes(StandardCharsets.ISO_8859_1);
                String fixedEncodedString = new String(bytes, StandardCharsets.UTF_8);
                fixedEncodedString=fixedEncodedString.replaceAll("\\\"","");
                dataWords.add(fixedEncodedString);
            }
            matches.add(dataWords);
        }

        return new ArrayList<>(matches);
    }

}
