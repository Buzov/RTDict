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
public class DownLoaderOfwords {
    
    //Этот спец. объект для построения строки
    private static StringBuilder sb = new StringBuilder();
    
    private static final String HTTP = "https://ssl.gstatic.com/dictionary/static/sounds/de/0/%s.mp3";
    private static final String PATH_TO_FILE = "D:/1. Books/En/8000/8000.txt";
    private static final String PATH_TO_FILE_MP3 = "D:/1. Books/En/8000/%s.mp3";
    private static final String PATH_TO_LOG = "D:/1. Books/En/8000/log.txt";
    private static final String SPACE = " ";

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
            while ((s = in.readLine()) != null /*&& number < 100*/) {
                number++;
                end = s.indexOf(SPACE);
                s = s.substring(0, end);
              
                f = new File(String.format(PATH_TO_FILE_MP3, s));
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
            System.out.println("dfgdfgd");
        }
    }
    
}
