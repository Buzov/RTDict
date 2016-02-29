package com.barracuda.rtdict.normalizer.wordnet;

/**
 *
 * @author RT
 */
public class TestNoun {
    public static void main(String[] args) {
        WordNetVerb wnn = new WordNetVerb();
        if(wnn.initialize("./wordnet/dict/")) {
            System.out.println("Ок!");
            String[] mas = {"are", "were", "has", "draws", "runs", "came", "have", "broken"};
            for(String s : mas) {
                System.out.println(wnn.getLemma(s));
            }
        }
        
        WordNetNoun noun = new WordNetNoun();
        if(noun.initialize("./wordnet/dict/")) {
            System.out.println("Ок!");
            String[] mas = {"I", "You", "dogs", "powersful", "drivers", "men", "women"};
            for(String s : mas) {
                System.out.println(noun.getLemma(s));
            }
        }
        
    }
}
