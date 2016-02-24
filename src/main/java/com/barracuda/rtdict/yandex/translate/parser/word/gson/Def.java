package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
@Table(name = "defs")
public class Def extends Model implements Serializable{
    
    private static final long serialVersionUID = 3805346717002233074L;

    @Column(name = "text")
    private String text;
    @Column(name = "pos")
    private String pos;
    @Column(name = "ts")
    private String ts;
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "tr_of_def",
            joinColumns = {@JoinColumn(name="def_id")},
            inverseJoinColumns = {@JoinColumn(name="tr_id")})
    private Set<Tr> tr;
    
    public Def() {
        
    }

    @JsonCreator
    public Def(
            @JsonProperty("text") String text, 
            @JsonProperty("pos") String pos, 
            @JsonProperty("ts") String ts, 
            @JsonProperty("tr") Set<Tr> tr) {
        this.text = text;
        this.pos = pos;
        this.ts = ts;
        this.tr = tr;
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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Set<Tr>  getTr() {
        return tr;
    }

    public void setTr(Set<Tr>  tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n");
        sb.append(text);
        sb.append("[");
        sb.append(ts);
        sb.append("]");
        sb.append("\n");
        sb.append("part of speech - ");
        sb.append(pos);
        sb.append("\n");
        for (Tr trsb : getTr()) {
            sb.append(" ");
            sb.append(trsb);
            //sb.append("\n");
        }
        return sb.toString();
    }
    
    

}

