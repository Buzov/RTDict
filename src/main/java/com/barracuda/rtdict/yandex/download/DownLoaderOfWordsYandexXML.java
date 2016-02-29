package com.barracuda.rtdict.yandex.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author artur
 */
public class DownLoaderOfWordsYandexXML {
    
    private static final String later = "i";
    private static final String s = "%s";
    
    //Этот спец. объект для построения строки
    private static StringBuilder sb = new StringBuilder();
    //https://dictionary.yandex.net/api/v1/dicservice.json/lookup
    //dictionary.artur
    // dict.1.1.20150825T123129Z.d03c8604a36c5758.4f06a1a0133898edd09f62a3bcbe5dd38344da6f&lang
    private static final String HTTP = "https://dictionary.yandex.net/api/v1/dicservice/lookup?key=dict.1.1.20150902T143602Z.0c58490324b0d519.7e658f7eef54c603d1b388078926cf692eec80b8&lang=en-ru&text=%s";
    private static final String PATH_TO_FILE = String.format("D:/1. Books/En/130000/%s/%s.txt", later, later);
    private static final String PATH_TO_FILE_XML = String.format("D:/1. Books/En/130000/%s/xml/%s.xml", later, s);
    private static final String PATH_TO_LOG = String.format("D:/1. Books/En/130000/%s/%s_log.txt", later, later);
    private static final String SPACE = " ";
    private static final String DOT = ".";

    public static void main(String[] args) {
        
        File file = new File(PATH_TO_FILE);
        File log = new File(PATH_TO_LOG);
        
        
        try (FileReader reader = new FileReader(file); 
                BufferedReader in = new BufferedReader(reader);
                FileWriter writer = new FileWriter(log, true)) {
            
            String s = null;
            int end;
            File f;
            int number = 0;
            while ((s = in.readLine()) != null /*&& number < 10*/) {
                number++;
                end = s.indexOf(DOT);
                if(end != -1) {
                    s = s.substring(0, end);
                }
              
                f = new File(String.format(PATH_TO_FILE_XML, s));
                try (
                    InputStream is = new URL(String.format(HTTP, s)).openStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    FileOutputStream fout = new FileOutputStream(f)) {

                    final byte data[] = new byte[1024];
                    int count;
                    while ((count = bis.read(data, 0, 1024)) != -1) {
                        fout.write(data, 0, count);
                    }
                    System.out.println("Привет №" + number + " Слово - " + s);
                } catch (Exception ex) {
                    System.out.println("Потоки");
                    sb.append(s);
                    sb.append("\n");
                    writer.write(s);
                    writer.write("\n");
                    writer.flush();
                }
                //sb.append(s.substring(0, end));
                //sb.append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
