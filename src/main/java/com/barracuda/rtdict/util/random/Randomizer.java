package com.barracuda.rtdict.util.random;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author RT
 */
public class Randomizer {
    
    String eng_rus_alphavit = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯяAaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    Random rnd = new Random(new Date().getTime());
        /// <summary>
        /// Перемешивание букв в слове за исключением первого и последнего символа
        /// </summary>
    
    public static void main(String[] args) {
        
    }
    
    public String rndSym(String word) {
            if (word.length() > 2) {
                String ret = "";
                //Построим массив случайно перемешанных индексов кроме первого и последнего
                int[] index = new int[word.length()];
                for (int i = 0; i < word.length(); i++)
                    index[i] = -1;
                index[0] = 0;
                index[word.length() - 1] = word.length() - 1;
                int v = rnd.next(1, word.length() - 1);
                rnd.nextBytes(new byte[]{2});
                for (int i = 1; i < word.length() - 1; i++) {
                    while (index[v] != -1)
                        v = rnd.next(1, word.length() - 1);
                    index[v] = i;
                }
                //Соберем слово используя массив индексов
                for (int i = 0; i < word.length(); i++) {
                    ret += word[index[i]];
                }
                return ret;
            }
            return word;
        }
        /// <summary>
        /// Преобразование текста
        /// </summary>
        private String TransformText(String text)
        {
            int begin;
            String nword;
            char[] array = text.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (eng_rus_alphavit.contains(array[i].toString())) {
                    begin = i;
                    while (eng_rus_alphavit.Contains(array[i].ToString()) && (++i < array.Length)) ;
                    nword = RndSym(text.Substring(begin, i - begin));
                    //Замена исходного слова на перемешанное
                    for (int j = begin; j < i; j++) {
                        array[j] = nword[j - begin];
                    }
                }
            }
            String ret = "";
            for (char c : array)
                ret += c;
            return ret;
        }
}
