package com.barracuda.rtdict.util.startdict;

import java.io.RandomAccessFile;

/**
 * http://strongexperts.narod.ru/ru/articles/archive/java2/2006/may2006-001/may2006-001.htm
 * http://strongexperts.narod.ru/ru/articles/archive/java2/2007/feb2007-001/feb2007-001.htm
 * http://habrahabr.ru/post/108076/
 * http://khpi-iip.mipk.kharkiv.edu/library/extent/prog/inter/string.html
 * 
 * http://devcolibri.com/2989
 * http://www.stardict.org/otherprojects.php
 * @author RT
 */
public class StartDict extends BaseStarDictItem {
    
    private static final String EXTENSION = "dict";
    private static final String MODE = "rw";
    
     /**
      * Маркер, определяющий форматирование словарной статьи
      */
    private String sameTypeSequence = null;
    
    private RandomAccessFile raf = null;

    // Маркер может быть составным (к примеру, sametypesequence = tm).
    // Виды одно-символьныx идентификаторов  словарных статей (для всех строчных идентификаторов текст в формате utf-8, заканчивается '\0'):
    // 'm' - просто текст в кодировке utf-8, заканчивается '\0' 
    // 'l' - просто текст в НЕ в кодировке utf-8, заканчивается '\0' 
    // 'g' - текст размечен с помощью языка разметки текста Pango
    // 't' - транскрипция в кодировке utf-8, заканчивается '\0' 
    // 'x' - текст в кодировке utf-8, размечен с помощью xdxf
    // 'y' - текст в кодировке utf-8, содержит китайские(YinBiao) или японские (KANA) символы 
    // 'k' - текст в кодировке utf-8, размечен с помощью  KingSoft PowerWord XML 
    // 'w' - текст размечен с помощью  MediaWiki
    // 'h' - текст размечен с помощью  Html
    // 'n' - текст размечен формате для WordNet
    // 'r' - текст содержит список ресурсов. Ресурсами могут быть файлы картинки (jpg), звуковые (wav), видео (avi), вложенные(bin) файлы и др.
    // 'W' - wav файл
    // 'P' - картинка
    // 'X' - этот тип зарезервирован для экспериментальных расширений
    

    public StartDict(String pathToDict, String sameTypeSequence) throws Exception {
        super(pathToDict, EXTENSION);
        this.sameTypeSequence = sameTypeSequence;
        System.out.println(pathToFile);
        raf = new RandomAccessFile(pathToFile, MODE);
    }
    
    public String getTranslation(int wordDataOffset, int wordDataSize) throws Exception {
        checkValidArguments(wordDataOffset, wordDataSize);
        byte[] byteArray = new byte[wordDataSize];
        // Читаем часть файла, относящегося к переводу слова
        // Смещаемся в нужно место файла
        raf.seek(wordDataOffset);
        // читаем n байт в созданный массив с указанной позиции 
        raf.read(byteArray, 0, wordDataSize);
               
        for(byte b : byteArray) {
            System.out.println(b);
        }
        // Вернем раскодированный в юникодную строку набор байтoв 
        return new String(byteArray, "utf-8");
    }
            
    private boolean checkValidArguments(int wordDataOffset, int wordDataSize) throws Exception {
        int endDataSize = wordDataOffset + wordDataSize;
        int realFileSize = 10000;
        if((wordDataOffset < 0) || (wordDataSize < 0) || (endDataSize > realFileSize)) {
            //throw new Exception();
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        // seaborne pos = 27420839 size = 436
        
        // country mile pos = 6647566 size = 162
        
        // are 1629095 size = 107
        // pos = 36500300 size = 49
        
        // pos = 7145555 size = 70
        
        /*
        severity pos = 28015689 size = 1660
        seville orange pos = 28017349 size = 115
        sevres pos = 28017464 size = 146
        sevres china pos = 28017610 size = 164
        sew pos = 28017774 size = 888
        sew in pos = 28018662 size = 190
        sew on pos = 28018852 size = 119
        sew over pos = 28018971 size = 141
        sew up pos = 28019112 size = 1135
        sewage pos = 28020247 size = 324
        sewage farm pos = 28020571 size = 68
        sewer pos = 28020639 size = 368
        sewer rat pos = 28021007 size = 103
        sewerage pos = 28021110 size = 121
        sewing pos = 28021231 size = 691
        sewing machine pos = 28021922 size = 157
        sewingbee pos = 28022079 size = 216
        sewingmaid pos = 28022295 size = 104
        sewingpress pos = 28022399 size = 105
        sewn pos = 28022504 size = 43
        sex pos = 28022547 size = 1848
        sex appeal pos = 28024395 size = 128
        sex bomb pos = 28024523 size = 106
        sex cell pos = 28024629 size = 75
        sex chromosome pos = 28024704 size = 93
        sex clinic pos = 28024797 size = 86
        sex gender pos = 28024883 size = 72
        sex gland pos = 28024955 size = 91
        sex hormone pos = 28025046 size = 81
        sex hygiene pos = 28025127 size = 72
        sex kitten pos = 28025199 size = 130
        sex object pos = 28025329 size = 413
        sex ratio pos = 28025742 size = 204
        sex role pos = 28025946 size = 434
        sex shop pos = 28026380 size = 236
        sex therapist pos = 28026616 size = 72
        sex therapy pos = 28026688 size = 113
        sex up pos = 28026801 size = 393
        pos = 36493747 size = 51
        */
        StartDict sd = new StartDict("./stardict", "");
        System.out.println(sd.getTranslation(28015689, 1660));
    }
}
