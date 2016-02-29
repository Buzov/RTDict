package com.barracuda.rtdict.normalizer.split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.barracuda.rtdict.normalizer.util.file.Lister.getFilesList;

/**
 *
 * @author RT
 */
public class Splitter {

    private static final String ENTER = "\n";
    /**
     * Расширение файла
     */
    private static final String[] EXP = {".txt", ".srt", ".fb2"};
    /**
     * Переменная с кодировкой
     */
    protected static final String ENCODING = "utf-8";
    /**
     * Шаблон
     */
    private static final String REGEX = "((?:[a-zA-Z]+[-']?)*[a-zA-Z]+)";
    private static final Pattern p = Pattern.compile(REGEX);
    
//    public List<String> initialize(String pathToBooks, String encoding) throws IOException {
//


//        /*for(Entry e : map.entrySet()) {
//         System.out.println("word = " + e.getKey() + " count = " + e.getValue());
//         }*/
//        System.out.println("size = " + listWords.size());
//        return true;
//    }
//    
    private static List<String> splitt(String pathToBooks, String encoding, String[] exp) throws IOException {
        List<File> listFiles = getFilesList(pathToBooks, exp);
        List<String> list = new LinkedList<>();
        for (File file : listFiles) {
            try (FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, encoding);
                    BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher m = p.matcher(line);
                    while (m.find()) {
                        list.add(m.group().toLowerCase());
                    }
                }
            }
        }
        return list;
    }
    
    /**
     * Возвращает объедененную строку из содержимого текстовых файлов.
     * 
     * @param pathToBooks Путь к тестовым файлам
     * @param encoding Кодировка текстовых файлов
     * @param exp Массив с расширениями фалов
     * @return Содержимое фалов в виде строки
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует 
     */
    private static String getStringFromFiles(String pathToBooks, String encoding, String[] exp) throws IOException {
        List<File> listFiles = getFilesList(pathToBooks, exp);
        StringBuilder sb = new StringBuilder();
        for (File file : listFiles) {
            try (FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, encoding);
                    BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append(ENTER);
                }
            }
        }
        return sb.toString();
    }  

//    private static List<String> splitt(String pathToBooks) throws IOException, IOException {
//        return splitt(pathToBooks, ENCODING, EXP);
//    }

    /**
     * Метод возвращает лист слов из переданной строки
     * 
     * @param words Строка со словами
     * @return Лист слов из переданной строки
     */
    private static List<String> splittUtil(String words) {
        return splittUtil(words, REGEX);
    }

    /**
     * Метод возвращает лист слов из переданной строки. Разбиение строки будет 
     * производиться по указанному регулярному выражению.
     * 
     * @param words Строка со словами
     * @param regex Регулярное выражение
     * @return Лист слов из переданной строки
     */
    private static List<String> splittUtil(String words, String regex) {
        List<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(words);
        while (matcher.find()) {
            list.add(matcher.group().toLowerCase());
        }
        return list;
    }
    
    /**
     * Метод вызвращает лист слов из текстовых файлов, которые расположены в 
     * указанном пути.
     * Файлы должны быть в корировке utf-8.
     * 
     * @param pathToBooks Путь к тектовым файлам
     * @return Лист слов из текстовых фалов
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<String> splitt(String pathToBooks) throws IOException {
        String s = getStringFromFiles(pathToBooks, ENCODING, EXP);
        return splittUtil(s);
    }
    
    public static void main(String[] args) throws IOException {
        for (String string : splitt("./books")) {
            System.out.println(string);
        }
    }

}
