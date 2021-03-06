package com.barracuda.rtdict.yandex.translate.parser.json.gson;


import com.barracuda.rtdict.dao.Factory;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Word;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RT
 */
public class YandexTest {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        Word word = gson.fromJson(readFile("./json/yandex_20.json"), Word.class);
        System.setProperty("console.encoding", "UTF-8");
        System.out.println(word);
        try {
            Factory.getInstance().getWordDAO().add(word);
        } catch (SQLException ex) {
            Logger.getLogger(YandexTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("taɪm");
    }

    private static String readFile(String file) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(file), "UTF8"));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }
}
