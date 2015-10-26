package com.barracuda.rtdict.yandex.translate.parser.word.jacson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public class Syn {

    private String text;
    private String pos;
    private String gen;
    private String anm;

    public Syn() {

    }

    public Syn(@JsonProperty("text") String text,
            @JsonProperty("pos") String pos,
            @JsonProperty("gen") String gen,
            @JsonProperty("anm") String anm) {
        this.text = text;
        this.pos = pos;
        this.gen = gen;
        this.anm = anm;
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getAnm() {
        return anm;
    }

    public void setAnm(String anm) {
        this.anm = anm;
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
            sb.append(", ");
        }
        if (gen != null) {
            sb.append("gen=");
            sb.append(gen);
            sb.append(", ");
        }
        if (anm != null) {
            sb.append("anm=");
            sb.append(anm);
        }
        //sb.append("\n");
        return sb.toString();
    }

}
