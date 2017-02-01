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

   public static void main( String args[] ) {
System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true  
System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)  
System.out.println("Output : "+Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true  
System.out.println("Output : "+Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched) 
System.out.println("[0-9A-Z]{7} --- 2YMW1ТN Output "+Pattern.matches("[A-Z0-9]{7}","2YMW1ТN"));//false ($ is not matched) 
System.out.println("[A-Z0-9]{7} --- 221KСF0 Output "+Pattern.matches("[A-Z0-9]{7}","2YMW1TN"));//false ($ is not matched) 
System.out.println("[A-Z0-9]{7} --- 21RQХDK Output "+Pattern.matches("[A-Z0-9]{7}","221KCF0"));//false ($ is not matched) 




   }

    
}
