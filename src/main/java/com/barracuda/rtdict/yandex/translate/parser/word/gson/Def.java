package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author RT
 */
public class Def {

    private String text;
    private String pos;
    private String ts;
    private List<Tr> tr;
    
    public Def() {
        
    }

    @JsonCreator
    public Def(@JsonProperty("text") String text, @JsonProperty("pos") String pos, @JsonProperty("ts") String ts, @JsonProperty("tr") List<Tr>  tr) {
        this.text = text;
        this.pos = pos;
        this.ts = ts;
        this.tr = tr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public List<Tr>  getTr() {
        return tr;
    }

    public void setTr(List<Tr>  tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n");
        sb.append(text);
        sb.append("[");
        sb.append(ts);
        sb.append("]");
        sb.append("\n");
        sb.append("part of speech - ");
        sb.append(pos);
        sb.append("\n");
        for (Tr trsb : getTr()) {
            sb.append(" ");
            sb.append(trsb);
            //sb.append("\n");
        }
        return sb.toString();
    }
    
    

}

