package com.barracuda.rtdict.normalizer.wordnet;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с нормализацией прилагательных
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetAdjective extends BaseWordNetItem {
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "er" заменяется на "" или  "e" и тд.
     */
    private static final List<Rule> listRule = new ArrayList<>();
    static {
        listRule.add(new Rule("er", ""));
        listRule.add(new Rule("er", "e"));
        listRule.add(new Rule("er", "e"));
        listRule.add(new Rule("est", "e"));
    }
    private static final String EXC = "adj.exc";
    private static final String INDEX = "index.adj";

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
