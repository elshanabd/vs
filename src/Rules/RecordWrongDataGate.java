/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import Properties.data.rules.ConfigProperties;
import WriteToFiles.OutputToFile;
import WrongDataRegister.WrongData;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Elshan.Abdullayev
 */
public class RecordWrongDataGate {
    
    private WrongData WDataObj;
    private OutputToFile Otf;
    
  
    
public void RecordingGate(String Counter, String VlrKod, String VlrDescription, String WrongData,String AccountNo) 
        throws FileNotFoundException, IOException, InvalidFormatException
{
    //System.out.println();
//    System.out.println("Counter:"+Counter);
//    System.out.println("VlrKod:"+VlrKod);
//    System.out.println("VlrDesc:"+VlrDescription);
//    System.out.println("WrongData:"+WrongData);
//    System.out.println("Account_no:"+AccountNo);
    
      WDataObj= new WrongData();
      Otf = new OutputToFile();
      
      WDataObj.setSaygac(Counter);
      WDataObj.setVLRkod(VlrKod);
      WDataObj.setVLRkod_description(VlrDescription);
      WDataObj.setWrong_data(WrongData);
      WDataObj.setAccount_no(AccountNo);
      
      
      //Otf.FillFile(WDataObj);    
      Otf.MakeExcel(WDataObj);
    
}


    
}
