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
@Table(name = "means")
public class Mean extends Model implements Serializable{
    
    private static final long serialVersionUID = 3706164166717687713L;

    @Column(name = "text")
    private String text;
    
    @ManyToMany(mappedBy = "mean")
    private Set<Tr> trs = new HashSet<>();
    
    public Mean() {
        
    }

    public Mean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Tr> getTrs() {
        return trs;
    }

    public void setTrs(Set<Tr> trs) {
        this.trs = trs;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
}
