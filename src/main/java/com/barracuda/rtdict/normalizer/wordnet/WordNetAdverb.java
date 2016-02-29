package com.barracuda.rtdict.normalizer.wordnet;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для нормалзации наречий
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetAdverb extends BaseWordNetItem {
    
     /**
     * Правила замены окончаний при нормализации слова по правилам.
     * У наречий есть только списки исключений(adv.exc) и итоговый список слов(index.adv).	
     * Правила замены окончаний при нормализации слова по правилам у наречий нет. 
     */
    private static final List<Rule> listRule = new ArrayList<>();
    private static final String EXC = "adv.exc";
    private static final String INDEX = "index.adv";
        
    // Метод получения нормализованной формы слова GetLemma(word) 
    // определен в базовом классе BaseWordNetItem
    
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
}
