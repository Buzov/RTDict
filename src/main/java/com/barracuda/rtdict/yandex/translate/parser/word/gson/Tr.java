package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RT
 */
public class Tr {

    private String text;
    private String pos;
    private List<Syn> syn = new ArrayList<>();
    private List<Mean> mean = new ArrayList<>();
    private List<Ex> ex = new ArrayList<>();

    public Tr() {

    }

    public Tr(String text,
            String pos,
            List<Syn> syn,
            List<Mean> mean,
            List<Ex> ex) {
        this.text = text;
        this.pos = pos;
        this.syn = syn;
        this.mean = mean;
        this.ex = ex;
    }
    
    public void addSyn(Syn syn) {
        this.syn.add(syn);
    }
    
    public void addMean(String text, String pos) {
        addSyn(new Syn(text, pos));
    }
    
    public void removeSyn(int id) {
        syn.remove(id);
    }
    
    public void addMean(Mean mean) {
        this.mean.add(mean);
    }
    
    public void addMean(String mean) {
        addMean(new Mean(mean));
    }
    
    public void removeMean(int id) {
        mean.remove(id);
    }
    
    public void addEx(Ex ex) {
        this.ex.add(ex);
    }
    
    public void addEx(String text) {
        addEx(new Ex(text));
    }
    
    public void removeEx(int id) {
        ex.remove(id);
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

    public List<Syn> getSyn() {
        return syn;
    }

    public void setSyn(List<Syn> syn) {
        this.syn = syn;
    }

    public List<Mean> getMean() {
        return mean;
    }

    public void setMean(List<Mean> mean) {
        this.mean = mean;
    }

    public List<Ex> getEx() {
        return ex;
    }

    public void setEx(List<Ex> ex) {
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
