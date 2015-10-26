package com.barracuda.rtdict.yandex.translate.parser.word.gson;

/**
 *
 * @author RT
 */
public class Mean {

    private String text;
    
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

    @Override
    public String toString() {
        return text;
    }
    
    
}
