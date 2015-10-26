package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public final class Word {

    public Def def[];
    
    public Word() {
        
    }

    @JsonCreator
    public Word(@JsonProperty("def") Def[] def) {
        this.def = def;
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
