package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.util.Set;

/**
 *
 * @author RT
 */
public final class Word {

    public Set<Def> def;
    
    public Word() {
        
    }

    public Word(Set<Def> def) {
        this.def = def;
    }

    public Set<Def> getDef() {
        return def;
    }

    public void setDef(Set<Def> def) {
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
