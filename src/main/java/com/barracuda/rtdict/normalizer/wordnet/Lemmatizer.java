/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.normalizer.wordnet;

/**
 *
 * @author artur
 */
public class Lemmatizer {
    
    /**
     * Разделитель составных слов	
     */
    private static final String SPLITTER = "-";
    private boolean state = false;
    
    private static final WordNetAdjective adj = new WordNetAdjective(); // Прилагательные
    private static final WordNetNoun noun = new WordNetNoun(); // Существительные
    private static final WordNetAdverb adverb = new WordNetAdverb(); // Наречия
    private static final WordNetVerb verb = new WordNetVerb(); // Глаголы
    
    private final BaseWordNetItem[] wordNet = {verb, adverb, adj, noun};
           
    
    public Lemmatizer(String pathToWordNetDict) {
        // Инициализируем объекты с частям речи
        boolean temp = true;
        for(BaseWordNetItem bwni : wordNet) {
            state = bwni.initialize(pathToWordNetDict);
            if(!state) {
                temp = state;
            }
        }
        state = temp;
    }
    
    public boolean isInit() {
        return state;
    }
    
    /**
     * Метод возвращает лемму слова (возможно, составного)
     * @param word Слово, которое нужно нормализовать, может быть следующего вида - 't-shirt'
     * @return 
     */
    public String getLemma(String word) {
        // Если в слове есть тире, разделим слово на части, нормализуем 
        // каждую часть(каждое слово) по отдельности, а потом соединим
        String[] words = word.split(SPLITTER);
        String lemma;
        for(int i = 0; i < words.length; i++) {
            lemma = getLemmaWord(words[i]);
            if(lemma != null) {
                words[i] = lemma;
            } else {
                return null;
            }
        }
        return String.join(SPLITTER, words);
    }
    
    /**
     * Метод возвращает лемму(нормализованную форму слова)
     * @param word - Слово, которое нужно нормализовать
     * @return Нормализованная форма слова
     */           
    private String getLemmaWord(String word) {
        for(int i = 0; i < wordNet.length; i++) {
            String lemma = wordNet[i].getLemma(word);
            if(lemma != null) {
                return lemma;
            }
            // lemma = null;
        }
        return null; 
    }
   
}
