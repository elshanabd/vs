/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author elshan.abdullayev
 */
public class PinCode {

   //private static final String REGEX = "[A-Z0-9]{7}";
   //private static final String INPUT = "21RQХDK";
    
    public static String aa="483АDZE";
    public static String bb="483ADZE";
    
    //public static String bd=" ";
    public static String bd="12.10.1986";
    

   public static void main( String args[] ) {
System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true  
System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)  
System.out.println("Output : "+Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true  
System.out.println("Output : "+Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched) 
System.out.println("[0-9A-Z]{7} --- 2YMW1ТN Output "+Pattern.matches("[A-Z0-9]{7}","2YMW1ТN"));//false ($ is not matched) 
System.out.println("[A-Z0-9]{7} --- 221KСF0 Output "+Pattern.matches("[A-Z0-9]{7}","2YMW1TN"));//false ($ is not matched) 
System.out.println("[A-Z0-9]{7} --- 21RQХDK Output "+Pattern.matches("[A-Z0-9]{7}","221KCF0"));//false ($ is not matched) 
System.out.println("[A-Z0-9]{7} --- 483АDZE Output Royal "+Pattern.matches("[A-Z0-9]{7}","483АDZE"));//from RB 
System.out.println("[A-Z0-9]{7} --- 483ADZE Output İAMAS "+Pattern.matches("[A-Z0-9]{7}","483ADZE"));//from İAMAS 
System.out.println("[A-Z0-9]{7} --- 58XXVPJ Output Kapital "+Pattern.matches("[A-Z0-9]{7}","58XXVPJ"));//from Kpt
System.out.println("[A-Z0-9]{7} --- 58XXVP* Output company "+Pattern.matches("[A-Z0-9]{7}","58XXVP*"));//from Company
System.out.println("[A-Z0-9]{7} --- 58XXVP* Output company "+Pattern.matches("[A-Z0-9]{7}","cvfre45*"));//from Company


System.out.println(aa.toString());

//String pattern ="[0-9Xx]{2}/[0-9Xx]{2}/[0-9Xx]{4}";

//if (bd.isEmpty()){
//    System.out.println(" Birth Date is null");
//            } else if (!bd.isEmpty()&&!bd.toUpperCase().matches(pattern)) {
//            System.out.println("Birth Date is not usable:  ["+bd+"]  format is date must be [dd/mm/yyy]");
//            }






   }

    
}
