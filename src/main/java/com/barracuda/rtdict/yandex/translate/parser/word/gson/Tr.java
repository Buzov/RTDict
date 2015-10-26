package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public class Tr {

    private String text;
    private String pos;
    private Syn syn[];
    private Mean mean[];
    private Ex ex[];

    public Tr() {

    }

    @JsonCreator
    public Tr(@JsonProperty("text") String text,
            @JsonProperty("pos") String pos,
            @JsonProperty("syn") Syn[] syn,
            @JsonProperty("mean") Mean[] mean,
            @JsonProperty("ex") Ex[] ex) {
        this.text = text;
        this.pos = pos;
        this.syn = syn;
        this.mean = mean;
        this.ex = ex;
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

    public Syn[] getSyn() {
        return syn;
    }

    public void setSyn(Syn[] syn) {
        this.syn = syn;
    }

    public Mean[] getMean() {
        return mean;
    }

    public void setMean(Mean[] mean) {
        this.mean = mean;
    }

    public Ex[] getEx() {
        return ex;
    }

    public void setEx(Ex[] ex) {
        this.ex = ex;
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

        sb.append("\n");
        if (getSyn() != null) {
            sb.append("     ");
            sb.append("Synonyms");
            sb.append("\n");
            for (Syn synsb : getSyn()) {
                sb.append("         ");
                sb.append(synsb);
                sb.append("\n");
            }
        }
        if (getMean() != null) {
            sb.append("     ");
            sb.append("Mean");
            sb.append("\n");
            for (Mean meansb : getMean()) {
                sb.append("         ");
                sb.append(meansb);
                sb.append("\n");
            }
        }
        if (getEx() != null) {
            
            sb.append("     ");
            sb.append("Examples");
            sb.append("\n");
            for (Ex exsb : getEx()) {
                sb.append("\n");
                sb.append("         ");
                sb.append(exsb);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}
