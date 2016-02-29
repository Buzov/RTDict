package com.barracuda.rtdict.normalizer.wordnet;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для нормализации глаголов
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetVerb extends BaseWordNetItem {
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "s" заменяется на "" , "ies" на и "y" тд.
     */
    private static final List<Rule> listRule = new ArrayList<>();
    static {
        listRule.add(new Rule("s", ""));
        listRule.add(new Rule("ies" , "y"));
        listRule.add(new Rule("es", "e"));
        listRule.add(new Rule("es", ""));
        listRule.add(new Rule("ed", "e"));
        listRule.add(new Rule("ed", ""));
        listRule.add(new Rule("ing", "e"));
        listRule.add(new Rule("ing", ""));	
    }
    private static final String EXC = "verb.exc";
    private static final String INDEX = "index.verb";

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
        
    // Метод получения нормализованной формы слова GetLemma(word) 
    // определен в базовом классе BaseWordNetItem
}
