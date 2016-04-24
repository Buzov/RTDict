package com.barracuda.rtdict.util.random;

/*
 Класс для перемешивания массивов коллекций
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Artur
 */
public class Randomizer {

    /**
     * Метод перемешивающий массивы. Используются стандартные средства JavaCore.
     *
     * @param list Массив для перемешивания
     */
    public static void shuffle(List<?> list) {
        Collections.shuffle(list);
    }

    /**
     * Метод перемешивающий массивы. Используются стандартные средства JavaCore.
     *
     * @param <T> Тип содержимого массива
     * @param list Массив для перемешивания
     * @return Перемешанный массив
     */
    public static <T> List<T> shuffleRx(List<T> list) {
        Collections.shuffle(list);
        return list;
    }

    /**
     * Метод перемешивающий массивы. Используются стандартные средства JavaCore.
     *
     * @param <T> Тип содержимого массива
     * @param list Массив для перемешивания
     * @return Перемешанный массив - копия исходного массива
     */
    public static <T> List<T> shuffleCopy(List<T> list) {
        List<T> tempList = new ArrayList<>(list.size());
        for(int i = 0; i < list.size(); i++) {
            tempList.add(null);
        }
        Collections.copy(tempList, list);
        Collections.shuffle(tempList);
        return tempList;
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> tempList = shuffleCopy(list);
        for (int i : tempList) {
            System.out.println(i);
        }
    }

}
