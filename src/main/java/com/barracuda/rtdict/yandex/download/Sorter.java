/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.yandex.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 *
 * @author artur
 */
public class Sorter {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("./list.txt");
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);
        String s = null;
        TreeSet<String> tree = new TreeSet<>();
        while ((s = in.readLine()) != null) {
            tree.add(s);
        }
        System.out.println(tree);
        File fileOut = new File("./list_sort.txt");
        FileWriter writer = new FileWriter(fileOut, true);
        for(String string : tree) {
            writer.write(string);
            writer.write("\n");
            writer.flush();
        }
    }
}
