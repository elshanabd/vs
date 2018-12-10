/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;
import Properties.data.rules.ConfigProperties;
import CreditParts.Header;
import CreditParts.Borrower;
import CreditParts.CreditDetails;
import CreditParts.Guarantees;
import CreditParts.Collateral;
import CreditParts.Tags;
import WriteToFiles.OutputToExcel;
import WriteToFiles.OutputToFile;
//import WriteToFiles.OutputToFile;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import WrongData;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/**
 *
 * @author Elshan.Abdullayev
 */
public class GeneralOutput {
    private OutputToExcel Otf;
     public void ResultsOutput(Borrower borrObj, ArrayList<Guarantees> guaranObj, CreditDetails crdetailsObj ,Collateral objColl, Header objHeader, String tag_name) 
            throws FileNotFoundException, IOException, ParseException, InvalidFormatException   { 
         int result = Integer.parseInt(crdetailsObj.getSaygac());
        if(result>300000){ 
         System.out.println("<tr><td>"
                 +crdetailsObj.getSaygac()+"</td><td>"
                 +crdetailsObj.getAccountNo()+"</td><td>"
                 +crdetailsObj.getCurrencyOfCredit()+"</td><td>"
                 +crdetailsObj.getCreditType()+"</td><td>"
                 +crdetailsObj.getInitialAmountOfCredit().trim()+"</td><td>"
                 +crdetailsObj.getCreditLineAmount().trim()+"</td><td>"
                 +crdetailsObj.getDisoutAmountOfCredit().trim()+"</td><td>"
                 +crdetailsObj.getAnnualInterestRate().trim()+"</td><td>"
                 +crdetailsObj.getPurposeOfCredit()+"</td><td>"
                 +crdetailsObj.getCreditPeriodInMonths()+"</td><td>"
                 +crdetailsObj.getDateOfGrant()+"</td><td>"
                 +crdetailsObj.getDueTimeFirstContract()+"</td><td>"
                 +crdetailsObj.getDueTimeLastContract()+"</td><td>"
                 +crdetailsObj.getLastPaymentDate()+"</td><td>"
                 +crdetailsObj.getMonthlyPaymentAmount()+"</td><td>"
                 +crdetailsObj.getDaysMainSumIsOverdue()+"</td><td>"
                 +crdetailsObj.getDaysInterestIsOverdue()+"</td><td>"
                 +crdetailsObj.getOiaForRepperiod()+"</td><td>"
                 +crdetailsObj.getNumberOfProlongs()+"</td><td>"
                 +crdetailsObj.getCreditClassCode()+"</td><td>"
                 +crdetailsObj.getCreditStatusCode()+"</td></tr>"
         );
        }
         //Otf = new OutputToExcel();
         //Otf.MakeExcel(crdetailsObj);
         
         
     
     }
    
}
