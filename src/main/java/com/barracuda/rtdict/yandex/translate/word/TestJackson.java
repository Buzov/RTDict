/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.yandex.translate.word;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**http://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
 * http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 *
 * @author artur
 */
public class TestJackson {

    public static void main(String[] args) throws IOException {
        //1. Convert Java object to JSON format
        ObjectMapper mapper = new ObjectMapper();
        Word word = mapper.readValue(new File("./json/lookup_1.json"), Word.class);
        System.out.println(word);
    }
}
