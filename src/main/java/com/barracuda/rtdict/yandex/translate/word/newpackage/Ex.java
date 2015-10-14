package com.barracuda.rtdict.yandex.translate.word.newpackage;

/**
 *
 * @author RT
 */
public class Ex {

    private String text;

    private Tr[] tr;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tr[] getTr() {
        return tr;
    }

    public void setTr(Tr[] tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        return "ClassPojo [text = " + text + ", tr = " + tr + "]";
    }
}
