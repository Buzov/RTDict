package com.barracuda.rtdict.yandex.translate.parser.word.gson;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "words")
public class Word extends Model implements Serializable {

    private static final long serialVersionUID = 3286702370981563231L;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "def_of_words",
            joinColumns = {
                @JoinColumn(name = "word_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "def_id")})
    public Set<Def> def;

    public Word() {

    }

    public Word(Set<Def> def) {
        this.def = def;
    }

    public Set<Def> getDef() {
        return def;
    }

    public void setDef(Set<Def> def) {
        this.def = def;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Def defsb : getDef()) {
            sb.append(defsb);
            //sb.append("\n");
        }
        return "------\n" + sb.toString() + "-----";
    }

}
