package com.barracuda.rtdict.util.startdict;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.barracuda.rtdict.normalizer.Normalizer;

/**
 *
 * @author RT
 */
public class Ifo extends BaseStarDictItem{
    
    private static final String EXTENSION = "ifo";
    private static final String BOOK_NAME = "bookname";
    private static final String WORD_COUNT = "wordcount";
    private static final String SYN_WORD_COUNT = "synwordcount";
    private static final String IDX_FILE_SIZE = "idxfilesize";

    private static Properties props = new Properties();
    /**
     * Название словаря [Обязательное поле]
     */
    private String bookName = null;
    
    /**
     * Количество слов в ".idx" файле [Обязательное поле]
     */
    private long wordCount = 0;
    
    /**
     * Количество слов в ".syn" файле синонимов [Обязательное поле, если есть 
     * файл ".syn"]
     */
    private long synWordCount = 0;

    /**
     * Размер (в байтах) ".idx" файла. Если файл сжат архиватором, то здесь 
     * указывается размер исходного несжатого файла [Обязательное поле]
     */
    private long idxFileSize = 0;
            

    public Ifo(String pathToDict) throws Exception {
        super(pathToDict, EXTENSION);
        
        try {
            //props.load(new FileInputStream(new File(pathToFile)));
            props.load(new FileReader(new File(pathToFile)));
            System.out.println(pathToFile);
        } catch (IOException ex) {
            Logger.getLogger(Normalizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Считаем из ifo файла параметры
        // Если хотя бы одно из обязательных полей отсутствует, вызовется 
        // исключение и словарь не будет загружен
        bookName = getString(BOOK_NAME);
        wordCount = getInt(WORD_COUNT);
        synWordCount = getInt(SYN_WORD_COUNT);
        idxFileSize = getInt(IDX_FILE_SIZE);
        //new String(props.getProperty("bookname").getBytes("Cp1251"), "UTF-8");
        //System.out.println(props.getProperty("bookname"));
    }
    
    private Integer getInt(String s) {
        String temp = getString(s);
        if(temp != null) {
            return Integer.valueOf(temp);
        }
        return 0;
    }
    
    private String getString(String s) {
        return props.getProperty(s);
    }
    
    
            
    public static void main(String[] args) throws Exception {
        Ifo ifo = new Ifo("./stardict");
        System.out.println(ifo.getBookName());
        System.out.println(ifo.getWordCount());
        System.out.println(ifo.getSynWordCount());
        System.out.println(ifo.getIdxFileSize());
    }
    
    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @return the wordCount
     */
    public long getWordCount() {
        return wordCount;
    }

    /**
     * @return the synWordCount
     */
    public long getSynWordCount() {
        return synWordCount;
    }

    /**
     * @return the idxFileSize
     */
    public long getIdxFileSize() {
        return idxFileSize;
    }
     
    /*
    
        # Если хотя бы одно из обязательных полей отсутствует, вызовется исключение и словарь не будет загружен

        
        
        
        self.idxOffsetBits = self.__getParameterValue("idxoffsetbits", 32)  # Размер числа в битах(32 или 64), содержащего внутри себя смещение до записи в файле .dict. Поле пояилось начиная с версии 3.0.0, до этого оно всегда было 32 [Необязательное поле]
        self.author = self.__getParameterValue("author", "") # Автор словаря [Необязательное поле]
        self.email = self.__getParameterValue("email", "") # Почта [Необязательное поле]
        self.description = self.__getParameterValue("description", "") # Описание словаря [Необязательное поле]
        self.date = self.__getParameterValue("date", "") # Дата создания словаря [Необязательное поле]
        self.sameTypeSequence = self.__getParameterValue("sametypesequence", None) # Маркер, определяющий форматирование словарной статьи[Обязательное поле]
        self.dictType = self.__getParameterValue("dicttype", "") # Параметр используется некоторыми словарными плагинами, например WordNet[Необязательное поле]			
    

    def __getParameterValue(self, key, defaultValue):
        try:
            return self.iniParser.GetValue(key) 
        except:
            if defaultValue != None:
                return defaultValue
            raise Exception('\n"%s" has invalid format (missing parameter: "%s")' % (self.dictionaryFile, key))	
    */

    
    
}