package com.barracuda.rtdict.yandex.translate.parser.word;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public final class Word {

    public Head head;
    public Def def[];
    
    public Word() {
        
    }

    @JsonCreator
    public Word(@JsonProperty("head") Head head, @JsonProperty("def") Def[] def) {
        this.head = head;
        this.def = def;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Def[] getDef() {
        return def;
    }

    public void setDef(Def[] def) {
        this.def = def;
    }
   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Def defsb : getDef()) {
            sb.append(defsb);
            //sb.append("\n");
        }
        return "------\n" + sb.toString() + "-----";
    }
  
}
