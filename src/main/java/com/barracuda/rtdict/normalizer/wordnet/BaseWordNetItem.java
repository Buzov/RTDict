package com.barracuda.rtdict.normalizer.wordnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RT
 */
public abstract class BaseWordNetItem {
    /**
     * Шаблон
     */
    private static final String REGEX = "[0-9]{8}";
    private static final Pattern p = Pattern.compile(REGEX);
    private Matcher m = null; 
    /**
     * Переменная с кодировкой
     */
    protected static final String ENCODING = "utf-8";
    /**
     * Словарь-кеш
     * Немного оптимизации. Кэш для уже нормализованных слов, 
     * ключ - ненормализованное слово, значение - нормализованное слово
     */
    protected Map<String, String> mapCash = new HashMap<>();
    /**
     * Индексный массив	
     */
    protected Map<String, ArrayList<String>> mapDict = new HashMap<>();
    /**
     * Словарь исключений
     */
    protected Map<String, String> mapEx = new HashMap<>();
    
    private String pathToWordNetDict = null;
    private File fileEx = null;
    private File fileIndex = null;
    
    public boolean initialize(String pathToWordNetDict) {
        this.pathToWordNetDict = pathToWordNetDict;
        fileEx = new File(this.pathToWordNetDict + getExc());
        fileIndex = new File(this.pathToWordNetDict + getIndex());
        if(!fileEx.exists() || !fileIndex.exists()) {
            return false;
        }
        if(fileEx.isDirectory() || fileIndex.isDirectory()) {
            return false;
        }
        try {
            appendExcDict(fileEx); // Заполним словарь исключений
            appendIndexDict(fileIndex); // Заполним индексный массив 
        } catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    private void appendExcDict(File file) throws IOException {
        // При разборе строки из файла, каждую строку разделяем на 2 слова и 
        // заносим слова в словарь(первое слово - ключ, второе - значение). 
        // При этом не забываем убрать с концов пробелы
        parseFile(file, mapEx, new Parser() {
                @Override
                public void parse(String s, Map map) {
                    String[] mas = s.split(" ");
                    if(mas.length >= 2) {
                        map.put(mas[0].replaceAll("_", " ").trim(), 
                                mas[1].replaceAll("_", " ").trim());
                    }
                }
        });
    }
    
    private void appendIndexDict(File file) throws IOException {
        // При разборе строки из файла, каждую строку разделяем на 2 слова и 
        // заносим слова в словарь(первое слово - ключ, второе - значение). 
        // При этом не забываем убрать с концов пробелы
        parseFile(file, mapDict, new Parser() {
                @Override
                public void parse(String s, Map map) {
                    String[] mas = s.split(" ");
                    
                    if(mas.length >= 8) {
                        ArrayList<String> arr = new ArrayList<>();
                        for(String str : mas) {
                            m = p.matcher(str);
                            if(m.matches()) {
                                arr.add(str);
                            }
                        }
                        map.put(mas[0].replaceAll("_", " ").trim(), 
                                arr);
                    }
                }
        });
    }
    
    private void parseFile(File file, Map map, Parser parser) throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(file); 
             InputStreamReader is = new InputStreamReader(fis);   
             BufferedReader br = new BufferedReader(is)) {
            String line;
            while ((line = br.readLine()) != null) {
                parser.parse(line, map);
            }
        }
    }
        
    /**
     * Метод проверяет слово на существование, и возвращает либо True, 
     * либо False.
     * Для того, чтобы понять, существует ли слово, проверяется индексный 
     * массив(там хранится весь список слов данной части речи).	
     * @param word Слово для проверки
     * @return 
     */
    protected boolean isDefined(String word){
        return mapDict.containsKey(word);
    }
    
    protected abstract List<Rule> getListRule();
    
    protected abstract String getExc();
    
    protected abstract String getIndex();
    
    
    public String getLemma(String word) {
        String s = word.toLowerCase();
        String lemma = null;
        // Пустое слово возвращаем обратно
        if(s == null) {
            return s;
        }
        
        // Пройдемся по кэшу, возможно слово уже нормализовывалось раньше 
        // и результат сохранился в кэше
        if(mapCash.containsKey(s)) {
            mapCash.get(s);
        }
        
        // Пройдемся по исключениям, если слово из исключений, вернем его 
        // нормализованную форму
        if(mapEx.containsKey(s)) {
            return mapEx.get(s);
        }
        
        // Проверим, если слово уже в нормализованном виде, вернем его же
        if(isDefined(s)) {
            return s;
        }

        // На этом шаге понимаем, что слово не является исключением и оно не 
        // нормализовано, значит начинаем нормализовывать его по правилам.
        lemma = ruleNormalization(s);
        if(lemma != null) {
            mapCash.put(s, lemma);
        }
        
        return lemma;
    }
    
    /**
     * Нормализация слова по правилам (согласно грамматическим правилам, 
     * слово приводится к нормальной форме)
     * @param word Слово для нормализации
     * @return 
     */
    public String ruleNormalization(String word) {
        List<Rule> listRule = getListRule();
        // Бежим по всем правилам, смотрим совпадает ли окончание слова с 
        // каким либо правилом, если совпадает, то заменяем окончние.
        for(Rule rule : listRule) {
            if(word.endsWith(rule.getKey())) {
                int pos = word.lastIndexOf(rule.getKey());
                String lemma = word.substring(0, pos); // Отрезаем старое окончание
                lemma = lemma + rule.getValue(); // Приклеиваем новое окончание
                //System.out.println("lemma = " + lemma);
                if(isDefined(lemma)) {
                    return lemma;
                }
            }
        }
        return null;
    }
    
}
