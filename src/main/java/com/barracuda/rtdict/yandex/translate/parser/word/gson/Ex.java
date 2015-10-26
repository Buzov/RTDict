package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public class Ex {

    private String text;
    private TrSecond tr[];
    
    public Ex() {
        
    }

    @JsonCreator
    public Ex(@JsonProperty("text") String text, @JsonProperty("tr") TrSecond[] tr) {
        this.text = text;
        this.tr = tr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TrSecond[] getTr() {
        return tr;
    }

    public void setTr(TrSecond[] tr) {
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
