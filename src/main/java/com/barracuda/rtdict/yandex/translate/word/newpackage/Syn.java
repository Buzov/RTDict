package com.barracuda.rtdict.yandex.translate.word.newpackage;

/**
 *
 * @author RT
 */
public class Syn {

    private String gen;

    private String text;

    private String anm;

    private String pos;

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnm() {
        return anm;
    }

    public void setAnm(String anm) {
        this.anm = anm;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "ClassPojo [gen = " + gen + ", text = " + text + ", anm = " + anm + ", pos = " + pos + "]";
    }
}
