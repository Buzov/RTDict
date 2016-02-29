package com.barracuda.rtdict.util.startdict;

import java.io.File;

/**
 *
 * @author RT
 */
public class BaseStarDictItem {
    
    private static final String EX_NOT_EXISTS = "Path '%s' does not exists";
    private static final String EX_IT_IS_NOT_DIRECTORY = "'%s' is not a directory";
    private static final String EXP = ".%s";
    
    /**
     * Переменная с кодировкой
     */
    protected static final String encoding = "utf-8";
    /**
     * Полный путь до файла
     */
    protected String pathToFile;
    /**
     * Размер файла
     */
    protected int realFileSize;
    
    protected BaseStarDictItem(String pathToDict, String exp) throws Exception {
        // Получаем полный путь до файла
        pathToFile = pathToFileInDirByExp(pathToDict, exp);
    }

    /**
     * Метод ищет в папке path первый попапвшийся файл с расширением exp 
     * @param path Путь к папке с фалом
     * @param exp Расширение файла
     * @return Возвращает полный путь к первому файлу с указанным расширением
     */
    private String pathToFileInDirByExp(String path, String exp) throws Exception {
        File f = new File(path);
        
        if(f.exists()) {
            if(f.isDirectory()) {
                for(String fileName : f.list()) {
                    if(fileName.endsWith(String.format(EXP, exp))) {
                        return f.getPath()+ "/" + fileName;
                    }
                }
            } else {
                throw new Exception(String.format(EX_IT_IS_NOT_DIRECTORY, path));
            }
        } else {
            throw new Exception(String.format(EX_NOT_EXISTS, path));
        }

        return null;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(new BaseStarDictItem("./stardict/", "idx").pathToFile);
    }

}
