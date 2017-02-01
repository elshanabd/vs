/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author elshan
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This is a simple program to create and modify the xlxs file.
 * 
 * @author Noman ali abbasi
 */
public class XExcel {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties bundle = new Properties();
        bundle.load(new FileInputStream(new File("configuration.properties")));
        Integer counter = Integer.parseInt(bundle.getProperty("loop.counter"));

        String titles[] = {"Firstname","Lastname","Country","Language"};
        String data[][] = {{"noman ali","abbasi","PK","EN"},{"ahsan","shaikh","PK","EN"},
                {"abdul jalil","ahmed","PK","EN"},{"umair","khan","PK","EN"},
                {"abdul rahim","khan","PK","EN"}};
        int rowCount = 0;

        try
        {
            File xlsxFile = new File("C:/workbook.xlsx");

            Workbook wb = null;
            Sheet sheet = null;
            Row row = null;

            if(xlsxFile.exists()){
                FileInputStream fileInputStream = new FileInputStream(xlsxFile);
                wb = new XSSFWorkbook(fileInputStream);
                sheet = wb.getSheet("Test");
                rowCount = sheet.getPhysicalNumberOfRows();

                System.err.println("Writingxisting file ....");
                for(int i = 0 ; i < counter ; i++){        
                    row = sheet.createRow(rowCount++);
                    int rndNumber = new Random().nextInt(3);
                    System.out.println(rndNumber);
                    for(int c = 0 ; c < titles.length ; c++){
                        Cell cell = row.createCell(c);                    
                        cell.setCellValue(data[rndNumber][c]);
                    }
                }

                System.err.println(xlsxFile.delete());                                
            }else{
                System.err.println("Creatingl file ....");

                wb = new XSSFWorkbook();
                sheet = wb.createSheet("Test");
                row = sheet.createRow(rowCount++);
                CellStyle cellStyle = wb.createCellStyle();
                Font font = wb.createFont();
                font.setBoldweight(Font.BOLDWEIGHT_BOLD);

                cellStyle.setFont(font);

                for(int i = 0 ; i < titles.length ; i++){
                    Cell cell = row.createCell(i);
                    cell.setCellValue(titles[i]);
                    cell.setCellStyle(cellStyle);
                }

                for(int i = 0 ; i < counter ; i++){        
                    row = sheet.createRow(rowCount++);
                    int rndNumber = new Random().nextInt(3);

                    for(int c = 0 ; c < titles.length ; c++){
                        Cell cell = row.createCell(c);                    
                        cell.setCellValue(data[rndNumber][c]);
                    }
                }
            }        

            FileOutputStream fileOut;
            try 
            {
                fileOut = new FileOutputStream("C:/workbook.xlsx",true);
                wb.write(fileOut);
                fileOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Last " + sheet.getLastRowNum() + ", " + sheet.getPhysicalNumberOfRows());            
        }catch(java.lang.IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
        }            
    }

}
