package com.barracuda.rtdict.normalizer;

import com.barracuda.rtdict.util.exel.ExelType;
import com.barracuda.rtdict.util.exel.ExelWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.barracuda.rtdict.normalizer.util.file.Lister;
import com.barracuda.rtdict.normalizer.split.Splitter;
import com.barracuda.rtdict.normalizer.wordnet.Lemmatizer;

/**
 * http://habrahabr.ru/post/161073/
 *
 * @author RT
 */
public class Normalizer {

    private static final String PATH_TO_BOOKS = "pathToBooks";
    private static final String PATH_TO_WORD_NET_DICT = "pathToWordNetDict";
    private static final String PATH_TO_STAR_DICT = "pathToStarDict";
    private static final String PATH_TO_RESULT = "pathToResult";
    private static final String COUNT_WORD = "countWord";

    private final Properties props = new Properties();
    private final String pathToBooks;
    private final String pathToWordNetDict;
    private final String pathToStarDict;
    private final String pathToResult;
    private final int countWord;

    private String pathToSetting = "./config/settings.ini";

//    private static String[] listPathToStarDict = null;
//    private static List<StartDict> listLanguageDict = new ArrayList<>();
//    private static String[] listBooks = null;
    private static final ExelWriter ew = new ExelWriter(ExelType.XLSX);

    private Lemmatizer lemmatizer;

    public Normalizer(String pathToSetting) {
        this.pathToSetting = pathToSetting;
        try {
            props.load(new FileInputStream(new File(pathToSetting)));
        } catch (IOException ex) {
            Logger.getLogger(Normalizer.class.getName()).log(Level.SEVERE, null, ex);
        }

        pathToBooks = props.getProperty(PATH_TO_BOOKS);
        pathToWordNetDict = props.getProperty(PATH_TO_WORD_NET_DICT);
        pathToStarDict = props.getProperty(PATH_TO_STAR_DICT);
        pathToResult = props.getProperty(PATH_TO_RESULT);
        countWord = Integer.valueOf(props.getProperty(COUNT_WORD));

        lemmatizer = new Lemmatizer(pathToWordNetDict);

        System.out.println(pathToBooks);
        System.out.println(pathToWordNetDict);
        System.out.println(pathToStarDict);
        System.out.println(pathToResult);
        System.out.println(countWord);
    }
//    
//    private boolen init() {
//        
//    }
//    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Normalizer normalizer = new Normalizer("./config/settings.ini");

        normalizer.run();

        // Отделяем пути словарей StarDict. Все пути заносим в список listPathToStarDict
        //listPathToStarDict = new File(pathToStarDict).list();
        // Для каждого из путей до словарей StarDict создаем свой языковый словарь
        /*for(String dict : listPathToStarDict) {
         //listLanguageDict.add(new StartDict(dict));
         }*/
        // Получаем список книг, из которых будем получать слова
        //listBooks = new File(pathToBooks).list();
            /*self.listBooks = self.__GetAllFiles(self.pathToBooks)/*

         // Создаем частотный словарь		
         /*self.frequencyDict = FrequencyDict(self.pathToWordNetDict)	*/
        // Подготовка закончена, загружены словари StarDict и WordNet. Запускаем задачу на выполнение, то есть начинаем парсить текстовые файл, нормализовывать и считать слова			
    }

    // Метод запускает задачу на выполнение
    public void run() {

        try {

            List<String> listWords = getSplitt();
            for (String word : listWords) {
                System.out.println(word);

                System.out.println(lemmatizer.getLemma(word));
                System.out.println("-----------");
            }

            ComparatorByValue cmp = new ComparatorByValue();
            Map<String, Integer> map = new HashMap<>();
            for (String word : listWords) {
                //System.out.println(s);
                String s = lemmatizer.getLemma(word);
                if (s != null) {
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    } else {
                        map.put(s, 1);
                    }
                }
            }
            Set<Entry<String, Integer>> set = map.entrySet();
            List<Entry<String, Integer>> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("words"));
            int i = 0;
            for (Map.Entry<String, Integer> entry : list) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue().toString());
                System.out.println(entry.getKey() + " ==== " + entry.getValue());
                i++;
            }

            try (FileOutputStream fs = new FileOutputStream(pathToResult)) {
                workbook.write(fs);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Отдаем частотному словарю по одной книге
            /*for book in self.listBooks:
             self.frequencyDict.ParseBook(book)	*/
            // Получаем первые countWord слов из всего получившегося списка английских слов
            /*mostCommonElements = self.frequencyDict.FindMostCommonElements(self.countWord)
            
             // Получаем переводы для всех слов
             for item in mostCommonElements:
             word = item[0]
             counterWord = item[1]
             valueWord = getTranslate(word);
             self.result.append([counterWord, word, valueWord])	*/
            // Запишем результат в файл формата Excel
            saveResultToExcel(null);
        } catch (IOException ex) {
            System.out.println("dfgdgfdgdfgdfgdg");
            Logger.getLogger(Normalizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Метод сохраняет результат(само слово, частота, его перевод) по первым countWord словам в файл формата Excel
    private static void saveResultToExcel(List<List<Object>> list) throws IOException {
        //ew.write(list, pathToResult, COUNT_WORD);
    }

    // Метод бежит по всем словарям, и возвращает перевод из ближайшего словаря. 
    // Если перевода нет ни в одном из словарей, возвращается пустая строка
    private static String getTranslate(String wordEn) {
        return null;
    }

    private List<String> getSplitt() throws IOException {
        return Splitter.splitt(pathToBooks);
    }

    // Метод создает список файлов, расположенных в папке pathToBooks	
    private List<File> getAllFiles() throws IOException {
        return Lister.getFilesList(pathToBooks);
    }

}

class ComparatorByValue implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() < e2.getValue()) {
            return 1;
        } else if (Objects.equals(e1.getValue(), e2.getValue())) {
            return 0;
        } else {
            return -1;
        }
    }
}
