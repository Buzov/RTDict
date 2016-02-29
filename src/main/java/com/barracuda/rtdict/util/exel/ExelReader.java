package com.barracuda.rtdict.util.exel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author RT
 */
public class ExelReader {
    private ExelType exelType = null;
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    
    public ExelReader(ExelType exelType) {
        this.exelType = exelType;
    }
    
    public List<List<String>> read(String path) throws IOException {
        Workbook wb = getWorkbook(path);
        List<List<String>> list = new ArrayList<>();
        for(Row r : wb.getSheetAt(0)) {
            List<String> l = new ArrayList<>();
            for(Cell c : r) {
                l.add(getCellText(c));
                System.out.println(getCellText(c));
            }
            list.add(l);
        }
        return list;
    }
    
    public ExelType getExelType() {
        return exelType;
    }
    
    private Workbook getWorkbook(String path) throws FileNotFoundException, IOException {
        Workbook workbook = null;
        switch (getExelType()) {
            case XLS:
                workbook = new HSSFWorkbook(new FileInputStream(path));
                break;
            case XLSX:
                workbook = new XSSFWorkbook(new FileInputStream(path));
                break;
        }
        return workbook;
    }
    
    private String getCellText(Cell cell) {
        String result = null;
        switch(cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    result = sdf.format(cell.getDateCellValue());
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        ExelReader er = new ExelReader(ExelType.XLSX);
        er.read("./word.xlsx");
    }
}
