package com.barracuda.rtdict.util.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author artur
 */
public class Test {

    public static void main(String args[]) {
        int[] solutionArray = {1, 2, 3, 4};

        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.print(solutionArray[i] + " ");
        }
        System.out.println();

        List<Integer> solution = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            solution.add(i);
        }
        Collections.shuffle(solution);
        for (Integer i : solution) {
            System.out.println(i);
        }
        // Create an array
        Integer[] array = new Integer[]{1, 2, 3, 4};

//int[] array = new int[]{1, 2, 3, 4}; //does not work
// Shuffle the elements in the array
        Collections.shuffle(Arrays.asList(array));
        System.out.println("-------------------");
        for (Integer i : array) {
            System.out.println(i);
        }

    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private void ShuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    private void ShuffleArray2(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static int[] RandomizeArray(int[] array) {
        Random rgen = new Random();  // Random number generator			

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    public static int[] RandomizeArray(int a, int b) {
        Random rgen = new Random();  // Random number generator		
        int size = b - a + 1;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = a + i;
        }

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        for (int s : array) {
            System.out.println(s);
        }

        return array;
    }
}
