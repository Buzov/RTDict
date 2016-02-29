package com.barracuda.rtdict.normalizer.wordnet;

/**
 *
 * @author RT
 */
public class TestLemma {

    public static void main(String[] args) {
        String[] mas = {"turned", "upturned", "used", "looking", "balancing", "asdadadadadadadasd", "are", "were", "has", "draws", "runs", "came", "have", "broken", "I", "You", "dogs", "powersful", "drivers", "men", "women", "women-have", "not"};
        Lemmatizer l = new Lemmatizer("./wordnet/dict/");

        if (l.isInit()) {
            for (String s : mas) {
                System.out.println(s);
                System.out.println(l.getLemma(s));
                System.out.println("-------");
            }
        }

    }
}
