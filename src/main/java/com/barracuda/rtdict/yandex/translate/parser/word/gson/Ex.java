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
@Table(name = "examples")
public class Ex extends Model implements Serializable{
    
    private static final long serialVersionUID = 3336265471590849960L;

    @Column(name = "text")
    private String text;
    @JoinTable(name = "ex_tr_second",
            joinColumns = {
                @JoinColumn(name = "ex_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tr_id")})
    private Set<TrSecond> tr;
    
    @ManyToMany(mappedBy = "ex")
    private Set<Tr> trs = new HashSet<>();
    
    public Ex() {
        
    }
    
    public Ex(String text) {
        this.text = text;
    }

    public Ex(String text, Set<TrSecond> tr) {
        this.text = text;
        this.tr = tr;
    }
    
    public void addTr(TrSecond trSecond) {
        tr.add(trSecond);
    }
    
    public void addTr(String trSecond) {
        addTr(new TrSecond(trSecond));
    }
    
    public void removeTr(int id) {
        tr.remove(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<TrSecond> getTr() {
        return tr;
    }

    public void setTr(Set<TrSecond> tr) {
        this.tr = tr;
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
        sb.append(text);
        sb.append("\n");
        /*sb.append("         ");
        sb.append("Перевод");
        sb.append("\n");*/
        for (TrSecond trsb : getTr()) {
            sb.append("         ");
            sb.append(trsb);
            //sb.append("\n");
        }
        return sb.toString();
    }
  
    
}
