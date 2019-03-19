

/**
 *
 * @author elshan_abdullayev
 */

package WriteToFiles;

import WrongDataRegister.WrongData;
import CreditParts.Header;
//import CreditParts.Tags;
//import Rules.XMLmaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.opc.OPCPackage;

//import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author elshan_abdullayev
 */


public class OutputToFile {
    
    ArrayList<WrongData> WrongDataList = new ArrayList<WrongData>();

    
    Header h;
    
  
    //private String pathDirectory="C:\\Users\\Elshan_Abdullayev.CBAR\\Documents";
    private String pathDirectory="D:\\";
    private String fileName;
    static String fn;
    public String FullFileName;
    public static String rand=String.valueOf(System.currentTimeMillis());

    public static String getRand() {
        return rand;
    }

    public static void setRand(String rand) {
        OutputToFile.rand = rand;
    }
    OutputStream outputStream;
//    FileInputStream inputStream;
//    XSSFWorkbook workbook;
//    XSSFCell cell;
//    XSSFRow row;
//    XSSFSheet sheet;
//    XSSFWorkbook wb;
    String sheetName = "Data_Table";
    File xlsxFile;

    
    Writer writer;
    static File file;
    static String ext=".xlsx";
    //String excelFileName;

//    public OutputToFile(String text) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    

    //public OutputToFile() {}
    
public void   FillFile(WrongData WrongDataObj) throws FileNotFoundException{
    WrongDataList.add(WrongDataObj);
    
//System.out.println(" Absolute Path: "+ pathDirectory+fn+"_"+rand+".cvs");
               
      //pathDirectory+"_"+fn+"_"+rand+".csv"
  outputStream = new FileOutputStream(file.getAbsoluteFile(),true);
  writer= new OutputStreamWriter(outputStream);
  
      try
{   

writer.write(WrongDataObj.getSaygac()
        +"#"+WrongDataObj.getVLRkod()
        +"#"+WrongDataObj.getVLRkod_description()
        +"#"+WrongDataObj.getWrong_data()
        +"#"+WrongDataObj.getAccount_no()
        +System.getProperty( "line.separator"));

writer.flush();
      
writer.close();

}catch(IOException i)
{
   i.printStackTrace();
   
}
    
    
    }

public void   MakeXML(ArrayList<String> XmlMassiv) throws FileNotFoundException{
  //XMLMakerList.add(XmlMakerObj);
    
  //System.out.println(" Absolute Path: "+ pathDirectory+fn+"_"+rand+".cvs");
  
  //System.out.println(" Absolute Path: MakeXML : "+ file.getAbsoluteFile());
  
               
      //pathDirectory+"_"+fn+"_"+rand+".csv"
  outputStream = new FileOutputStream(file.getAbsoluteFile(),true);
        try {
            writer= new OutputStreamWriter(outputStream,"UTF8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(OutputToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
  
      try
{
    
    for (int i=0; i<XmlMassiv.size();i++)
    {
   // System.out.println(" i= "+i+" elements : "+XmlMassiv.get(i));
    
    writer.write(XmlMassiv.get(i)+System.getProperty( "line.separator"));
    }


        //+"#"+WrongDataObj.getVLRkod_description()
        //+"#"+WrongDataObj.getWrong_data()
        //+"#"+WrongDataObj.getAccount_no()
        
//        +System.getProperty( "line.separator")




writer.flush();
      
writer.close();




}catch(IOException i)
{
   i.printStackTrace();
   
}
    
    
    }


public void   MakeExcel(WrongData WrongDataObj) 
        throws FileNotFoundException, IOException, InvalidFormatException{
    WrongDataList.add(WrongDataObj);
      File dir = new File("./Extract");
    if(!dir.isDirectory())dir.mkdirs();
   String excelFileName = dir+File.separator+fn+"_"+rand+ext;//name of excel file
   xlsxFile = new File(excelFileName);
  
  //System.out.println("AP : "+excelFileName);
   if(!xlsxFile.isFile()){
      
      //FileInputStream fis = new FileInputStream(new File(excelFileName));
       FileOutputStream fos = new FileOutputStream(new File(excelFileName));
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      XSSFSheet sheet = workbook.createSheet("Table_Data");
      XSSFRow row1 = sheet.createRow(0);
		XSSFCell r1c1 = row1.createCell(0);
		r1c1.setCellValue("NO");
		XSSFCell r1c2 = row1.createCell(1);
		r1c2.setCellValue("VLR_CODE");
		XSSFCell r1c3 = row1.createCell(2);
                r1c3.setCellValue("DESCRIPTION");
                XSSFCell r1c4 = row1.createCell(3);
                r1c4.setCellValue("WRONG_DATA");
                XSSFCell r1c5 = row1.createCell(4);
                r1c5.setCellValue("ACCOUNT_NO");
      XSSFRow row2 = sheet.createRow(1);          
                XSSFCell r2c1 = row2.createCell(0);
		r2c1.setCellValue(WrongDataObj.getSaygac());
		XSSFCell r2c2 = row2.createCell(1);
		r2c2.setCellValue(WrongDataObj.getVLRkod());
		XSSFCell r2c3 = row2.createCell(2);
                r2c3.setCellValue(WrongDataObj.getVLRkod_description());
                XSSFCell r2c4 = row2.createCell(3);
                r2c4.setCellValue(WrongDataObj.getWrong_data());
                XSSFCell r2c5 = row2.createCell(4);
                r2c5.setCellValue(WrongDataObj.getAccount_no());

      
      workbook.write(fos);
      fos.close();
      //System.out.println(excelFileName+" file created successfully");
   } else 
   {
       //System.out.println(" File exists");
       FileInputStream fis = new FileInputStream(new File(excelFileName));
       XSSFWorkbook workbook = new XSSFWorkbook(fis); 
       XSSFSheet sheet = workbook.getSheetAt(0);
       XSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);  
                XSSFCell r2c1 = row.createCell(0);
		r2c1.setCellValue(WrongDataObj.getSaygac());
		XSSFCell r2c2 = row.createCell(1);
		r2c2.setCellValue(WrongDataObj.getVLRkod());
		XSSFCell r2c3 = row.createCell(2);
                r2c3.setCellValue(WrongDataObj.getVLRkod_description());
                XSSFCell r2c4 = row.createCell(3);
                r2c4.setCellValue(WrongDataObj.getWrong_data());
                XSSFCell r2c5 = row.createCell(4);
                r2c5.setCellValue(WrongDataObj.getAccount_no());
                

      fis.close();
                FileOutputStream fos =new FileOutputStream(new File(excelFileName));
	        workbook.write(fos);
	        fos.close();
		//System.out.println("Done");
       
 
   }
             

    
}

public void createNewFile() throws IOException
{
    //fn=fn.replaceAll("!@#$%^&*?", "");
    File dir = new File("./Extract");
    if(!dir.isDirectory())dir.mkdirs();
    file=new File(dir+File.separator+fn+"_"+rand+".txt");
    file.createNewFile();
    //System.out.println(file.getAbsoluteFile());
    System.out.println("Creating new file: "+file.getAbsolutePath());
    
}


public String takeFilePath() {
    if(file!=null)
        return file.getAbsolutePath();
    else 
        return "";
}

 public void setFileName(String fileName) throws IOException {
     
     if(!fileName.contentEquals(""))
     { setRand(String.valueOf(System.currentTimeMillis()));
        this.fileName = fileName; 
        fn=this.fileName;
        System.out.println("  Set File Name : "+this.fileName + " FN : "+fn);
        
        createNewFile();
     }
 
 }
 
  public String getFileName() {
      //System.out.println("  Get File Name : "+fileName);
        return fileName;
    }

public  void HeaderInfo (Header h)
{
              System.out.println("Bank ID :  "+h.getBankId());
              System.out.println("Bank Name :  "+h.getBankName());
              System.out.println("Report Date :  "+h.getReportDate());
    
}
    
}
