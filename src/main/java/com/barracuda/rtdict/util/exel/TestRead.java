/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.util.exel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author artur
 */
public class TestRead {
    public static void main(String[] args) throws IOException {
        Workbook wb = new HSSFWorkbook(new FileInputStream("./my.xls"));
        for(int i = 0; i < 25; i++) 
        System.out.println(wb.getSheetAt(0).getRow(i).getCell(0));
    }
}
