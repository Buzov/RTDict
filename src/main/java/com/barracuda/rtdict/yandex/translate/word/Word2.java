/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.barracuda.rtdict.yandex.translate.word;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author artur
 */
public final class Word2 {
    public final Head head;
    public final Def def[];

    @JsonCreator
    public Word2(@JsonProperty("head") Head head, @JsonProperty("def") Def[] def){
        this.head = head;
        this.def = def;
    }

    public static final class Head {

        @JsonCreator
        public Head(){
        }
    }

    public static final class Def {
        public final String text;
        public final String pos;
        public final String ts;
        public final Tr tr[];

        @JsonCreator
        public Def(@JsonProperty("text") String text, @JsonProperty("pos") String pos, @JsonProperty("ts") String ts, @JsonProperty("tr") Tr[] tr){
            this.text = text;
            this.pos = pos;
            this.ts = ts;
            this.tr = tr;
        }

        public static final class Tr {
            public final String text;
            public final String pos;
            public final String asp;
            public final Mean mean[];
            public final Ex ex[];
    
            @JsonCreator
            public Tr(@JsonProperty("text") String text, @JsonProperty("pos") String pos, @JsonProperty("asp") String asp, @JsonProperty("mean") Mean[] mean, @JsonProperty("ex") Ex[] ex){
                this.text = text;
                this.pos = pos;
                this.asp = asp;
                this.mean = mean;
                this.ex = ex;
            }
    
            public static final class Mean {
                public final String text;
        
                @JsonCreator
                public Mean(@JsonProperty("text") String text){
                    this.text = text;
                }
            }
    
            public static final class Ex {
                public final String text;
                public final Tr2 tr[];
        
                @JsonCreator
                public Ex(@JsonProperty("text") String text, @JsonProperty("tr") Tr2[] tr){
                    this.text = text;
                    this.tr = tr;
                }
        
                public static final class Tr2 {
                    public final String text;
            
                    @JsonCreator
                    public Tr2(@JsonProperty("text") String text){
                        this.text = text;
                    }
                }
            }
        }
    }
}
