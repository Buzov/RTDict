package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author RT
 */
@Entity
@Table(name = "synonyms")
public class Syn extends Model implements Serializable{
    
    private static final long serialVersionUID = 7524146001604523603L;

    @Column(name = "text")
    private String text;
    @Column(name = "pos")
    private String pos;
    
    @ManyToMany(mappedBy = "syn")
    private Set<Tr> trs = new HashSet<>();

    public Syn() {

    }

    public Syn(String text, String pos) {
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

    public Set<Tr> getTrs() {
        return trs;
    }

    public void setTrs(Set<Tr> trs) {
        this.trs = trs;
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
