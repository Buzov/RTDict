package com.barracuda.rtdict.normalizer.wordnet;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с нормализацией существительных
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetNoun extends BaseWordNetItem {
    
    private static final String FUL = "ful";
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "s" заменяется на "", "ses" заменяется на "s" и тд.
     */
    private static final List<Rule> listRule = new ArrayList<>();
    static {
        listRule.add(new Rule("s", ""));
        listRule.add(new Rule("’s", ""));
        listRule.add(new Rule("’", ""));
        listRule.add(new Rule("ses", "s"));
        listRule.add(new Rule("xes", "x"));
        listRule.add(new Rule("zes", "z"));
        listRule.add(new Rule("ches", "ch"));
        listRule.add(new Rule("shes", "sh"));
        listRule.add(new Rule("men", "man"));
        listRule.add(new Rule("ies", "y"));
    }
    private static final String EXC = "noun.exc";
    private static final String INDEX = "index.noun";
    
    @Override
    protected List<Rule> getListRule() {
        return listRule;
    }
    
    @Override
    protected String getExc() {
        return EXC;
    }

    @Override
    protected String getIndex() {
        return INDEX;
    }
    
    /**
     * Метод возвращает лемму сушествительного(нормализованную форму слова)
     *  Этот метод есть в базовом классе BaseWordNetItem, но нормализация 
     * существительных несколько отличается от нормализации других частей речи, 
     * поэтому метод в наследнике переопределен
     * @param word
     * @return 
     */
    @Override
    public String getLemma(String word) {
        String s = word.toLowerCase();
        String lemma = null;
        // Пустое слово возвращаем обратно
        if(s == null) {
            return s;
        }
        
        // Если существительное слишком короткое, то к нормализованному 
        // виду мы его не приводим	
        if (s.length() <= 2) {
            return s;
        }
        
        // Если существительное заканчивается на "ss", то к нормализованному 
        // виду мы его не приводим
        if (s.endsWith("ss")) {
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
        
        // Если существительное заканчивается на "ful", значит отбрасываем "ful", 
        // нормализуем оставшееся слово, а потом суффикс приклеиваем назад.
        // Таким образом, к примеру, из слова "spoonsful" после нормализации 
        // получится "spoonful"
        String suff = "";
        if(s.endsWith(FUL)) {
            s = s.substring(0, s.length()-3);
            suff = FUL;
        }

        // На этом шаге понимаем, что слово не является исключением и оно не 
        // нормализовано, значит начинаем нормализовывать его по правилам.
        lemma = ruleNormalization(s);
        if(lemma != null) {
            if(suff.equals(FUL)) {
                lemma = lemma + suff;
                // Не забываем добавить суффикс "ful", если он был
            }
            mapCash.put(s, lemma);
        } /*else {
            return s;
        }*/
        
        return lemma;
    }  

}
