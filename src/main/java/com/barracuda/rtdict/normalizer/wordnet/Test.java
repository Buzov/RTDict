/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.normalizer.wordnet;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author artur
 */
public class Test {
    
    private static final String REGEX = "[0-9]{8}";
    static Pattern p = Pattern.compile(REGEX);
    static  Matcher m = null; 
    
    public static void main(String[] args) {
        
        String d = "powerful";
        
        if(d.endsWith("ful")) {
            d = d.substring(0, d.length()-3);
            System.out.println(d);
        }
        
        String[] mas = {"0266597", "002665974", "12345678"};
        for(String s : mas) {
            m = p.matcher(s);
            if(m.matches()) {
                System.out.println(s);
            }
        }
        
        
        Map<String, String> mapRule = new HashMap<>();
        mapRule.put("s", "");
        mapRule.put("ed", "");
        mapRule.put("ing", "sdfsf");
        
        String[] s = {"runs", "bring", "studed"};
        
        String word = "runs";
        for(String ss : s) {
            for(Map.Entry<String, String> e : mapRule.entrySet()) {
                if(ss.endsWith(e.getKey())) {
                    int pos = ss.lastIndexOf(e.getKey());
                    String lemma = ss.substring(0, pos)+ e.getValue();
                    System.out.println("lemma = " + lemma);
                    break;
                }
            }
        }
        
    }
}
