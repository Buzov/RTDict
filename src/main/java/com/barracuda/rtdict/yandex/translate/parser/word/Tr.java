package com.barracuda.rtdict.yandex.translate.parser.word;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author RT
 */
public class Tr {

    private String text;
    private String pos;
    private String gen;
    private String asp;
    private String anm;
    private Syn syn[];
    private Mean mean[];
    private Ex ex[];

    public Tr() {

    }

    @JsonCreator
    public Tr(@JsonProperty("text") String text,
            @JsonProperty("pos") String pos,
            @JsonProperty("gen") String gen,
            @JsonProperty("asp") String asp,
            @JsonProperty("anm") String anm,
            @JsonProperty("syn") Syn[] syn,
            @JsonProperty("mean") Mean[] mean,
            @JsonProperty("ex") Ex[] ex) {
        this.text = text;
        this.pos = pos;
        this.gen = gen;
        this.asp = asp;
        this.anm = anm;
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getAsp() {
        return asp;
    }

    public void setAsp(String asp) {
        this.asp = asp;
    }

    public String getAnm() {
        return anm;
    }

    public void setAnm(String anm) {
        this.anm = anm;
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
        if (gen != null) {
            sb.append("gen=");
            sb.append(gen);
            sb.append(", ");
        }
        if (asp != null) {
            sb.append("asp=");
            sb.append(asp);
            sb.append(", ");
        }
        if (anm != null) {
            sb.append("anm=");
            sb.append(anm);
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
