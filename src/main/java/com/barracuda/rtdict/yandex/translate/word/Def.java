package com.barracuda.rtdict.yandex.translate.word;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
// Do not use fields to autodetect. use the public getter methods to autodetect properties
//@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.PUBLIC_ONLY)
public class Def {
        //@JsonProperty
        private String text;
        //@JsonProperty
        private String pos;
        //@JsonProperty
        private String ts;

        @JsonCreator
        public Def(@JsonProperty("text") String text, @JsonProperty("pos") String pos, @JsonProperty("ts") String ts) {
            this.text = text;
            this.pos = pos;
            this.ts = ts;
        }

        //@JsonProperty("text")
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        //@JsonProperty("pos")
        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        //@JsonProperty("ts")
        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }
        
        

        @Override
        public String toString() {
            return "\n" + text + "[" + ts + "]" + "\n" + "part of speech - " + pos;
        }
}
