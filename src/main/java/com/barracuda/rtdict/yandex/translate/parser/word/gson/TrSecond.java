package com.barracuda.rtdict.yandex.translate.parser.word.gson;

/**
 *
 * @author RT
 */
public class TrSecond {

    private String text;
    
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

    @Override
    public String toString() {
        return text;
    }
    
    
}
