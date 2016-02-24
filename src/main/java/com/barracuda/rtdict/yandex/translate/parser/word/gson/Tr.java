package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "translations")
public class Tr extends Model implements Serializable {

    private static final long serialVersionUID = 7459685054346581572L;

    @Column(name = "text")
    private String text;
    @Column(name = "pos")
    private String pos;
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "tr_syn",
            joinColumns = {
                @JoinColumn(name = "tr_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "syn_id")})
    private Set<Syn> syn;
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "tr_mean",
            joinColumns = {
                @JoinColumn(name = "tr_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "mean_id")})
    private Set<Mean> mean;
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "tr_ex",
            joinColumns = {
                @JoinColumn(name = "tr_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "ex_id")})
    private Set<Ex> ex;

    @ManyToMany(mappedBy = "tr")
    private Set<Def> defs = new HashSet<>();

    public Tr() {

    }

    public Tr(String text,
            String pos,
            Set<Syn> syn,
            Set<Mean> mean,
            Set<Ex> ex) {
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

    public Set<Syn> getSyn() {
        return syn;
    }

    public void setSyn(Set<Syn> syn) {
        this.syn = syn;
    }

    public Set<Mean> getMean() {
        return mean;
    }

    public void setMean(Set<Mean> mean) {
        this.mean = mean;
    }

    public Set<Ex> getEx() {
        return ex;
    }

    public void setEx(Set<Ex> ex) {
        this.ex = ex;
    }

    public Set<Def> getDefs() {
        return defs;
    }

    public void setDefs(Set<Def> defs) {
        this.defs = defs;
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
