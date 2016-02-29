package com.barracuda.rtdict.normalizer.util.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс Lister выводит отсортированный список содержимого пути, переданного ему
 * в качестве аргумента. Если аргумента нет, выводится сождержимое текущей
 * директории.
 *
 * @author RT
 */
public class Lister {

    /**
     * Расширение файла
     */
    private static final String[] EXP = {".txt", ".srt", ".fb2"};
    public static final String[] EXP_FOR_ALL = {""};

    public static void print(List<File> files) {
        files.stream().forEach((f) -> {
            System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
        });
    }

    /**
     * Метод выводит на печать имена всех файлов и папок, которые находяться в
     * переданном пути
     *
     * @param pathname Путь к файлу или директории
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static void printAll(String pathname) throws IOException {
        print(getAll(pathname));
    }

    /**
     * Метод выводит на печать имена всех папок, которые находяться в переданном
     * пути
     *
     * @param pathname Путь к файлу или директории
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static void printDirectories(String pathname) throws IOException {
        print(getDirectoriesList(pathname));
    }

    /**
     * Метод выводит на печать имена всех файлов, которые находяться в
     * переданном пути
     *
     * @param pathname Путь к файлу или директории
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static void printFiles(String pathname) throws IOException {
        print(getFilesList(pathname));
    }

    /**
     * Метод выводит на печать имена всех файлов, которые находяться в
     * переданном пути и имеют указанное расширение exp
     *
     * @param pathname Путь к файлу или директории
     * @param exp Список расширений файлов для отбора
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static void printFiles(String pathname, String[] exp) throws IOException {
        print(getFilesList(pathname, exp));
    }

    /**
     * Метод возвращает лист File из указанного пути
     *
     * @param pathname Путь к файлу или директории
     * @param typeFiles Параметр указывает какие типы будут храниться в списке
     * @param exp Список расширений файлов для отбора
     * @return Список File
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getList(String pathname, TypeFiles typeFiles, String[] exp) throws IOException {
        List<File> list = new ArrayList<>();
        File path = new File(pathname);
        if (!path.exists()) {
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
        Files.walk(Paths.get(pathname)).forEach(filePath -> {
            switch (typeFiles) {
                case ALL: {
                    list.add(filePath.toFile());
                    break;
                }
                case DIRECTORIES: {
                    if (Files.isDirectory(filePath)) {
                        list.add(filePath.toFile());
                    }
                    break;
                }
                case FILES: {
                    if (Files.isRegularFile(filePath)) {
                        for (String s : exp) {
                            if (filePath.toString().endsWith(s)) {
                                list.add(filePath.toFile());
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        });
        return list;
    }

    /**
     * Метод возвращает список всех File из указанного пути
     * 
     * @param pathname Путь к файлу или директории
     * @return Список всех File
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getAll(String pathname) throws IOException {
        return getList(pathname, TypeFiles.ALL, null);
    }
    
    /**
     * Метод возвращает отсортированый список всех File из указанного пути
     * 
     * @param pathname Путь к файлу или директории
     * @return Oтсортированый список всех File
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getAllSort(String pathname) throws IOException {
        List<File> list = getList(pathname, TypeFiles.ALL, null);
        list.sort(new FilesComparator());
        return list;
    }

    /**
     * Метод возвращает список всех директорий 
     * 
     * @param pathname Путь к файлу или директории
     * @return Список всех директорий
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getDirectoriesList(String pathname) throws IOException {
        return getList(pathname, TypeFiles.DIRECTORIES, null);
    }

    /**
     * Метод возвращает список всех файлов с расширение по умолчанию
     * 
     * @param pathname Путь к файлу или директории
     * @return Список всех файлов с расширением по умолчанию
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getFilesList(String pathname) throws IOException {
        return getList(pathname, TypeFiles.FILES, EXP);
    }
    
    /**
     * Метод возвращает список всех файлов
     * 
     * @param pathname Путь к файлу или директории
     * @return Список всех файлов
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует 
     */
    public static List<File> getFilesListAll(String pathname) throws IOException {
        return getList(pathname, TypeFiles.FILES, EXP_FOR_ALL);
    }

    /**
     * Метод возвращает список всех файлов с указанным расширением
     * 
     * @param pathname Путь к файлу или директории
     * @param exp Список расширений файлов для отбора
     * @return Список всех файлов с указанным расширением
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<File> getFilesList(String pathname, String[] exp) throws IOException {
        return getList(pathname, TypeFiles.FILES, exp);
    }

    public static void main(String[] args) throws IOException {
        String path = "./";
        print(getAll(path));
        System.out.println("-------------------");
        print(getAllSort(path));
        System.out.println("-------------------");
        print(getFilesList(path, EXP_FOR_ALL));
    }

    /**
     * Comparator для сортировки списка File
     * При сортировке приоритет отдается директориям
     */
    private static class FilesComparator implements Comparator<File> {

        @Override
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            }
            if (f1.isFile() && f2.isDirectory()) {
                return 1;
            }
            return f1.compareTo(f2);
        }
    }
}
