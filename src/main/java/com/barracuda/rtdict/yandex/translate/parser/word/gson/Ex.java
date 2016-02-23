package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.util.Set;

/**
 *
 * @author RT
 */
public class Ex {

    private String text;
    private Set<TrSecond> tr;
    
    public Ex() {
        
    }
    
    public Ex(String text) {
        this.text = text;
    }

    public Ex(String text, Set<TrSecond> tr) {
        this.text = text;
        this.tr = tr;
    }
    
    public void addTr(TrSecond trSecond) {
        tr.add(trSecond);
    }
    
    public void addTr(String trSecond) {
        addTr(new TrSecond(trSecond));
    }
    
    public void removeTr(int id) {
        tr.remove(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<TrSecond> getTr() {
        return tr;
    }

    public void setTr(Set<TrSecond> tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append("\n");
        /*sb.append("         ");
        sb.append("Перевод");
        sb.append("\n");*/
        for (TrSecond trsb : getTr()) {
            sb.append("         ");
            sb.append(trsb);
            //sb.append("\n");
        }
        return sb.toString();
    }
  
    
}
