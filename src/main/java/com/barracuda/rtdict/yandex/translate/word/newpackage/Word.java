package com.barracuda.rtdict.yandex.translate.word.newpackage;

/**
 *
 * @author RT
 */
public class Word {

    private Def[] def;

    private String head;

    public Def[] getDef() {
        return def;
    }

    public void setDef(Def[] def) {
        this.def = def;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "ClassPojo [def = " + def + ", head = " + head + "]";
    }
}
