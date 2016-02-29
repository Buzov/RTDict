package com.barracuda.rtdict.util.exel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author artur
 */
public class TestExel {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String s1 = "wordwewrwrwrwrw";
        String s2 = "[word]";
        String s3 = "слово";
        Workbook wbx = new XSSFWorkbook(); // xlsx
        Workbook wb = new HSSFWorkbook(); // xls
        
        Sheet sheet1 = wb.createSheet("mySheet1");
        // Set the width (in units of 1/256th of a character width)
        sheet1.setColumnWidth(1, 5000);
        sheet1.autoSizeColumn(0);
        sheet1.addMergedRegion(new CellRangeAddress(0, 4, 4, 8));
        
        
        Row row = sheet1.createRow(0);
        row.setHeightInPoints(45);
        
        CellStyle style = wb.createCellStyle();
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderBottom(CellStyle.BORDER_DASH_DOT_DOT);
        style.setBottomBorderColor(IndexedColors.GREEN.getIndex());
        
        Font font = wb.createFont();
        font.setFontName("Word");
        font.setFontHeightInPoints((short) 25);
        font.setBold(true);
        font.setStrikeout(true);
        font.setUnderline(Font.U_SINGLE);
        font.setColor(IndexedColors.RED.getIndex());
        row.createCell(0).setCellValue(s1);
        style.setFont(font);
        
        Cell c = row.createCell(1);
        
        c.setCellStyle(style);
        c.setCellValue(s2);
        row.createCell(2).setCellValue(s3);

        Sheet sheet2 = wb.createSheet(WorkbookUtil.createSafeSheetName("word"));
        FileOutputStream fs = new FileOutputStream("my2.xls");
        wb.write(fs);
        fs.close();
    }
}
