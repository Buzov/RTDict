package com.barracuda.rtdict.yandex.translate.word.newpackage;

/**
 *
 * @author RT
 */
public class Def {

    private String text;

    private String ts;

    private Tr[] tr;

    private String pos;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Tr[] getTr() {
        return tr;
    }

    public void setTr(Tr[] tr) {
        this.tr = tr;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "ClassPojo [text = " + text + ", ts = " + ts + ", tr = " + tr + ", pos = " + pos + "]";
    }
}
