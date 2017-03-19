package com.fzz.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;

/**
 * Created by fzz on 2017/3/19.
 */

public class JxlUtil {
    public static void main(String[] args) {
        try {
            Workbook workbook = Workbook.getWorkbook(new File("e:/jxl.xls"));

            Sheet sheet=workbook.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j <sheet.getColumns() ; j++) {
                    Cell cell = sheet.getCell(j, i);
                    System.out.print(cell.getContents()+" ");

                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void createExcel(){
        String[] title={"id","name","sex"};
        File file = new File("e:/jxl.xls");
        try {
            file.createNewFile();
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet=workbook.createSheet("sheet1",0);
            Label label=null;
            for (int i = 0; i <title.length ; i++) {
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            for (int i = 1; i <10 ; i++) {
                label=new Label(0,i,"100"+i);
                sheet.addCell(label);
                label=new Label(1,i,"fzz");
                sheet.addCell(label);
                label=new Label(2,i,"nan");
                sheet.addCell(label);

            }
            workbook.write();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
