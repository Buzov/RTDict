package com.barracuda.rtdict.yandex.translate.parser.json.jacson;

import com.barracuda.rtdict.yandex.translate.parser.word.jacson.Word;
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author RT
 */
public class YandexTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Word word = mapper.readValue(new File("./json/yandex_20.json"), Word.class);
        System.setProperty("console.encoding", "UTF-8");
        System.out.println(word);
        System.out.println("taɪm");
    }
}
