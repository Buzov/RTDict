package com.barracuda.rtdict.yandex.translate.word;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
 
// ignore the property with name 'tags'.
@JsonIgnoreProperties({"head"})
// Do not use fields to autodetect. use the public getter methods to autodetect properties
//@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.PUBLIC_ONLY)
public class Word {
    //@JsonProperty
    private Def def[];
    
    @JsonCreator
    public Word(@JsonProperty("def") Def[] def) {
        this.def = def;
    }

    //@JsonProperty("def")
    public Def[] getDef() {
        return def;
    }

    
    public void setDef(Def[] def) {
        this.def = def;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Def def1 : def) {
            sb.append(sb);
        }
        return "------" + sb.toString() + "\n------";
    }
    
}
