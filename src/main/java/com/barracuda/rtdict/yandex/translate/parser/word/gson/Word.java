package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RT
 */
public final class Word {

    public List<Def> def = new ArrayList<>();
    
    public Word() {
        
    }

    public Word(List<Def> def) {
        this.def = def;
    }

    public List<Def> getDef() {
        return def;
    }

    public void setDef(List<Def> def) {
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
