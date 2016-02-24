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
@Table(name = "translations_of_examples")
public class TrSecond extends Model implements Serializable{
    
    private static final long serialVersionUID = 6909185162522103367L;

    @Column(name = "text")
    private String text;
    
    @ManyToMany(mappedBy = "tr")
    private Set<Ex> trs = new HashSet<>();
    
    public TrSecond() {
        
    }

    public TrSecond(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Ex> getTrs() {
        return trs;
    }

    public void setTrs(Set<Ex> trs) {
        this.trs = trs;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
}
