package com.barracuda.rtdict.util.startdict;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * This Class is used for reading .idx file.
 * @author kien
 */
public class IdxFile {
    
    /**
     * {'иностр.слово': [Смещение_до_записи_в_файле_dict, Размер_всей_записи_в_файле_dict], ...}
     */
    private Map<String, Pos> idxDict = new TreeMap<>();
    /** constant of 0x000000FF. */
    private final int byteFirst = 0x000000FF;

    /** constant of 0x0000FF00. */
    private final int secondByte = 0x0000FF00;

    /** constant of 0x00FF0000. */
    private final int thirdByte = 0x00FF0000;

    /** constant of 0xFF000000. */
    private final int fourthByte = 0xFF000000;

    /** constant of 0xFFFFFFFFL. */
    private final long fixthByte = 0xFFFFFFFFL;

    /** constant of number 3. */
    private final int noThree = 3;

    /** constant of number 8. */
    private final int noEight = 8;

    /** constant of number 9. */
    private final int noNine = 9;

    /** constant of number 16. */
    private final int noSixteen = 16;

    /** constant of number 24. */
    private final int noTwentyFour = 24;

    /** constant of number 4. */
    private final int aByte = 4;

    /** path to the ".idx" file. */
    private String strFileName;

    /** decide if the properties are loaded. */
    private boolean boolIsLoaded = false;

    /** number of word. */
    private long longWordCount;

    /** File size. */
    private long longIdxFileSize;


    /**
     * constructor.
     * @param fileName path to .idx file.
     * @param wordCount number of word.
     * @param fileSize the file size.
     */
    public IdxFile(String fileName, long wordCount, long fileSize) {
        longWordCount = wordCount;
        longIdxFileSize = fileSize;
        strFileName = fileName;
        load();
    }

    /**
     * accessor of longIdxFileSize.
     * @return longIdxFileSize
     */
    public long getLongIdxFileSize() {
        return longIdxFileSize;
    }

    /**
     * accessor of boolIsLoaded.
     * @return boolIsLoaded
     */
    public boolean isLoaded() {
        return boolIsLoaded;
    }

    /**
     * accessor of longWordCount.
     * @return longWordCount
     */
    public long getLongWordCount() {
        return longWordCount;
    }

    /**
     * accessor of strFileName.
     * @return strFileName
     */
    public String getStrFileName() {
        return strFileName;
    }

    /**
     * load properties.
     */
    public void load() {
        if (boolIsLoaded || (!(new java.io.File(strFileName)).exists())) {
            return;
        }
        try {
            DataInputStream dt = new DataInputStream(new BufferedInputStream(new FileInputStream(strFileName)));
            byte[] bt = new byte[(int) longIdxFileSize];
            dt.read(bt);
            dt.close();

            int startPos; // start position of entry
            int endPos = 0; // end position of entry

            
            for (long i = 0; i < longWordCount; i++) {
                
                // read the word
                startPos = endPos;
                while (bt[endPos] != '\0') {
                    endPos++;
                }
                String word = new String(bt, startPos, endPos - startPos, "UTF8");
                //tempEntry.setStrLwrWord(tempEntry.getStrWord().toLowerCase());
                // read the offset of the meaning (in .dict file)
                ++endPos;
                long offSet = readAnInt32(bt, endPos);
                // read the size of the meaning (in .dict file)
                endPos += aByte;
                long size = readAnInt32(bt, endPos);
                endPos += aByte;
                idxDict.put(word, new Pos(offSet, size));
            }
            boolIsLoaded = true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    /**
     * convert 4 char array to an integer.
     * @param str array of byte that is read from .idx file.
     * @param beginPos the position of a word.
     * @return a long.
     */
    private long readAnInt32(byte[] str, int beginPos) {
        int firstByte = (byteFirst & ((int) str[beginPos]));
        int secondByte = (byteFirst & ((int) str[beginPos + 1]));
        int thirdByte = (byteFirst & ((int) str[beginPos + 2]));
        int fourthByte = (byteFirst & ((int) str[beginPos + noThree]));

        return ((long) (firstByte << noTwentyFour | secondByte << noSixteen | thirdByte << noEight | fourthByte))
                & fixthByte;
    }
    
    private void print() {
        for(Entry<String, Pos> e : idxDict.entrySet()) {
            System.out.println(e.getKey() + " pos = " + e.getValue().getPos() + " size = " + e.getValue().getSize());
        }
    }
    
    public static void main(String[] args) {
        //seaborne pos = 27420839 size = 436
        IdxFile ifo = new IdxFile("./stardict/magus.idx", 109600, 2012797);
        ifo.print();
    }

}
