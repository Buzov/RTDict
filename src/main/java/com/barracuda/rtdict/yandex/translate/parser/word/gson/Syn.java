package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public class Syn {

    private String text;
    private String pos;

    public Syn() {

    }

    public Syn(@JsonProperty("text") String text,
            @JsonProperty("pos") String pos) {
        this.text = text;
        this.pos = pos;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if (text != null) {
            sb.append("text=");
            sb.append(text);
            sb.append(", ");
        }
        if (pos != null) {
            sb.append("pos=");
            sb.append(pos);
        }

        //sb.append("\n");
        return sb.toString();
    }

}
