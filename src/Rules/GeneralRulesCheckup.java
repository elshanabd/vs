package Rules;

/*
 * To change this template, choose Tools | Templatesf
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */
//import WrongDataRegister.WrongData;
import Properties.data.rules.ConfigProperties;
import CreditParts.Header;
import CreditParts.Borrower;
import CreditParts.CreditDetails;
import CreditParts.Guarantees;
import CreditParts.Collateral;
import CreditParts.Tags;
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
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class GeneralRulesCheckup {
    
 //public ArrayList<Borrower> dBorrower = new  ArrayList<Borrower>();
 //public ArrayList<Guarantees> dGuarantees = new  ArrayList<Guarantees>();
 //public ArrayList<CreditDetails> dCreditDetails = new  ArrayList<CreditDetails>();
 //public ArrayList<Collateral> dCollateral = new  ArrayList<Collateral>();
 
 public Header header;
 public Borrower borrower;
 public Guarantees guarantee;
 public CreditDetails creditdetails;
 public Collateral collateral;
 public Tags tag;
 
 //Borrower objBorr;
 //WrongData WDataObj;
 
  ConfigProperties prop;
  ConfigProperties properties;
  
  RecordWrongDataGate recWrDG;
  XMLmaker makeXml;
  //ResourceBundle bundle = ResourceBundle.getBundle("resc/resources/settings");
  
  
  //String yerli_vesiqeler=bundle.getString("id");

  String yerli_vesiqeler=prop.getAll().get("id"); 
  String xarici_vesiqeler=prop.getAll().get("id2");
  String FullName=prop.getAll().get("FullName");
  String CountryCode=prop.getAll().get("CountryCode");
  String BankrupcyStatus=prop.getAll().get("BankrupcyStatus");
  String DateOfBirth=prop.getAll().get("DateOfBirth");
  String generaldate=prop.getAll().get("GeneralDateStandart");
  String placeofbirth=prop.getAll().get("PlaceOfBirth");
  String PinCode=prop.getAll().get("PinCode");
  String accountno=prop.getAll().get("AccountNo");
  String currency=prop.getAll().get("CurrencyOfCredit");
  String credittype=prop.getAll().get("CreditType");
  String mebleg=prop.getAll().get("Mebleg");
  String purposeofcredit=prop.getAll().get("PurposeOfCredit");
  String creditperiodinmonths=prop.getAll().get("CreditPeriodInMonths");
  String lastpaymentdate=prop.getAll().get("GeneralDateStandart");
  String digits=prop.getAll().get("positiveNumbers");
  String classcodeofcredit=prop.getAll().get("CreditClassCode");
  String statuscodeofcredit=prop.getAll().get("CreditStatusCode");
  String collateraltypecode=prop.getAll().get("CollateralTypeCode");
  
  //String accountno="[A-Za-z0-9-_()]{0,40}$";
  //String currency="^[AZN|USD|EUR|RUB|GBP]{0,3}$";
  //String credittype="^[001|002|003|004|005|006|007|008]{0,3}$";
  //String purposeofcredit="^[001|002|003|004|005|006|007|008|009|010]{0,3}$";
  //String classcodeofcredit="^[001|002|003|004|005|006]{0,3}$";
  //String statuscodeofcredit="^[001|003|007|008]{0,3}$";
  //String mebleg="^[0-9.]$";
  //String mebleg="[\\-\\+]?[0-9]*(\\.[0-9]+)?";
  //String positivenumbers="[[\\+]?[0-9]{1,}";

  Pattern aze_ptrn=Pattern.compile(yerli_vesiqeler);
  Pattern nonaze_ptrn=Pattern.compile(xarici_vesiqeler);
  
  
  Pattern fname= Pattern.compile(FullName);
  Pattern countrycode=Pattern.compile(CountryCode);
  Pattern bankRupcyStatus=Pattern.compile(BankrupcyStatus);
  Pattern dateofbirth=Pattern.compile(DateOfBirth);
  Pattern date = Pattern.compile(generaldate);
  Pattern bplace= Pattern.compile(placeofbirth);
  Pattern pincode= Pattern.compile(PinCode);
  
  Pattern craccount= Pattern.compile(accountno);
  Pattern crcurrency= Pattern.compile(currency);
  Pattern crcredittype= Pattern.compile(credittype);
  Pattern crmebleg= Pattern.compile(mebleg);
  Pattern crpurposeofcredit= Pattern.compile(purposeofcredit);
  Pattern crcreditperiodinmonths=Pattern.compile(creditperiodinmonths);
  Pattern crlastpaymentdate= Pattern.compile(lastpaymentdate);
  Pattern digit = Pattern.compile(digits);
  Pattern crclasscode= Pattern.compile(classcodeofcredit);
  Pattern crstatuscode= Pattern.compile(statuscodeofcredit);
  Pattern crcollateraltypecode=Pattern.compile(collateraltypecode);
  
  SimpleDateFormat  df = new SimpleDateFormat("dd/MM/yyyy");
  java.util.Date granted_on;
  java.util.Date first_contract_no;
  java.util.Date last_contract_on;
  java.util.Date dates;
  java.util.Date last_payment_date;
  Calendar cal=null;
  Matcher m;
  Integer   Flag=0;
  String tag_name;
    
    public void ResultsCheck(Borrower borrObj, ArrayList<Guarantees> guaranObj, CreditDetails crdetailsObj ,Collateral objColl, Header objHeader, String tag_name) 
            throws FileNotFoundException, IOException, ParseException, InvalidFormatException   {
 
 recWrDG = new RecordWrongDataGate();
 cal = Calendar.getInstance();
 makeXml = new XMLmaker();

/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/**********************Borcalan Məlumatlarının yoxlanması***************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
    if(borrObj!=null)
      {
  if(borrObj.getId()==null)
  {Flag++;//  System.out.println("1");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<id>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getId()!=null && (!aze_ptrn.matcher(borrObj.getId().trim()).matches()&&!nonaze_ptrn.matcher(borrObj.getId().trim()).matches())) 
  {Flag++;// System.out.println("2");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKOD100"),
        prop.getAll().get("VLR100"),
        borrObj.getId(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getName()==null)
  {Flag++;// System.out.println("3");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<name>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getName()!=null && !fname.matcher(borrObj.getName()).matches()) 
  {//Flag++;// System.out.println("4");
//        recWrDG.RecordingGate(borrObj.getSaygac(),
//        prop.getAll().get("VLRKOD110"),
//        prop.getAll().get("VLR110"),
//        borrObj.getName(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getCountryCode()==null)
  {Flag++;// System.out.println("4+");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CountryCode>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getCountryCode()!=null && !countrycode.matcher(borrObj.getCountryCode()).matches()) 
  {Flag++;// System.out.println("5");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKOD120"),
        prop.getAll().get("VLR120"),
        borrObj.getCountryCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getBankruptcyStatus()==null)
  {Flag++;// System.out.println("6");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<BankruptcyStatus>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getBankruptcyStatus()!=null && !bankRupcyStatus.matcher(borrObj.getBankruptcyStatus()).matches()) 
  {Flag++;// System.out.println("7");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKOD130"),
        prop.getAll().get("VLR130"),
        borrObj.getBankruptcyStatus(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getDateOfBirth()==null)
  {//Flag++;// System.out.println("8");
//        recWrDG.RecordingGate(borrObj.getSaygac(),
//        prop.getAll().get("VLRKODXML")+"<DateOfBirth>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if((borrObj.getDateOfBirth()!=null && borrObj.getDateOfBirth()!="") && !dateofbirth.matcher(borrObj.getDateOfBirth()).matches()) 
  {Flag++;// System.out.println("8+");
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKOD140"),
        prop.getAll().get("VLR140"),
        borrObj.getDateOfBirth(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getPlaceOfBirth()==null)
  {//Flag++;// System.out.println("9");
//        recWrDG.RecordingGate(borrObj.getSaygac(),
//        prop.getAll().get("VLRKODXML")+"<PlaceOfBirth>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getPlaceOfBirth()!=null && !bplace.matcher(borrObj.getPlaceOfBirth()).matches()) 
  {//Flag++;// System.out.println("10");
//        recWrDG.RecordingGate(borrObj.getSaygac(),
//        prop.getAll().get("VLRKOD150"),
//        prop.getAll().get("VLR150"),
//        borrObj.getPlaceOfBirth(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(borrObj.getPinCode()==null)
  {//Flag++;// System.out.println("11");
//        recWrDG.RecordingGate(borrObj.getSaygac(),
//        prop.getAll().get("VLRKODXML")+"<PinCode>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(borrObj.getPinCode()!=null && borrObj.getPinCode().trim()!="" && !pincode.matcher(borrObj.getPinCode().trim().toUpperCase()).matches()) 
  {Flag++;//  System.out.println("12 BOrr pin "+borrObj.getPinCode());
        recWrDG.RecordingGate(borrObj.getSaygac(),
        prop.getAll().get("VLRKOD160"),
        prop.getAll().get("VLR160"),
        borrObj.getPinCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
      } else 
    {
        Flag++;// System.out.println("13");
        recWrDG.RecordingGate(null,
        prop.getAll().get("VLRKODXML")+"<Borrower>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null"); 
    }
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/**********************Zamin Məlumatlarının yoxlanması******************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/

  if(guaranObj!=null)
      {
          for(int i=0;i<guaranObj.size();i++){
              
  if(guaranObj.get(i).getId()==null)
  {Flag++;// System.out.println("13");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKODXML")+"Zamin<id>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(guaranObj.get(i).getId()!=null && (!aze_ptrn.matcher(guaranObj.get(i).getId().trim()).matches()&&!nonaze_ptrn.matcher(guaranObj.get(i).getId().trim()).matches())) 
  {Flag++;// System.out.println("14");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKOD200"),
        prop.getAll().get("VLR200"),
        guaranObj.get(i).getId(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(guaranObj.get(i).getName()==null)
  {Flag++;// System.out.println("15");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKODXML")+"Zamin<name>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(guaranObj.get(i).getName()!=null && !fname.matcher(guaranObj.get(i).getName()).matches()) 
  {//Flag++;// System.out.println("15+");
//        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
//        prop.getAll().get("VLRKOD210"),
//        prop.getAll().get("VLR210"),
//        guaranObj.get(i).getName(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(guaranObj.get(i).getCountryCode()==null)
  {Flag++;// System.out.println("16");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKODXML")+"Zamin<CountryCode>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(guaranObj.get(i).getCountryCode()!=null && !countrycode.matcher(guaranObj.get(i).getCountryCode()).matches()) 
  {Flag++;// System.out.println("17");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKOD220"),
        prop.getAll().get("VLR220"),
        guaranObj.get(i).getCountryCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(guaranObj.get(i).getDateOfBirth()==null)
  {//Flag++;// System.out.println("18");
//        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
//        prop.getAll().get("VLRKODXML")+"Zamin<DateOfBirth>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if((guaranObj.get(i).getDateOfBirth()!=null && guaranObj.get(i).getDateOfBirth()!="") && !dateofbirth.matcher(guaranObj.get(i).getDateOfBirth()).matches()) 
  {Flag++;// System.out.println("19");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKOD240"),
        prop.getAll().get("VLR240"),
        guaranObj.get(i).getDateOfBirth(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(guaranObj.get(i).getPlaceOfBirth()==null)
  {//Flag++;// System.out.println("20");
//        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
//        prop.getAll().get("VLRKODXML")+"Zamiddn<PlaceOfBirth>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(guaranObj.get(i).getPlaceOfBirth()!=null && !bplace.matcher(guaranObj.get(i).getPlaceOfBirth()).matches()) 
  {//Flag++;// System.out.println("21");
//        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
//        prop.getAll().get("VLRKOD250"),
//        prop.getAll().get("VLR250"),
//        guaranObj.get(i).getPlaceOfBirth(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(guaranObj.get(i).getPinCode()==null)
  {//Flag++;// System.out.println("22");
//        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
//        prop.getAll().get("VLRKODXML")+"Zamin<PinCode>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(guaranObj.get(i).getPinCode()!=null && guaranObj.get(i).getPinCode().trim()!="" && !pincode.matcher(guaranObj.get(i).getPinCode().trim().toUpperCase()).matches()) 
  {Flag++;// System.out.println("23");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKOD260"),
        prop.getAll().get("VLR260"),
        guaranObj.get(i).getPinCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if((borrObj.getId()!=null && guaranObj.get(i).getId()!=null) &&
      borrObj.getId().contentEquals(guaranObj.get(i).getId()))
  {Flag++;// System.out.println("23");
        recWrDG.RecordingGate(guaranObj.get(i).getSaygac(),
        prop.getAll().get("VLRKOD232"),
        prop.getAll().get("VLR232"),
        guaranObj.get(i).getId()+"="+borrObj.getId(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
      
  }
          }
      }

/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/**********************Kredit Melumatlarının yoxlanması*****************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/

  if(crdetailsObj.getAccountNo()==null)
  {Flag++;// System.out.println("24");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<AccountNo>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getAccountNo()!=null && !craccount.matcher(crdetailsObj.getAccountNo()).matches()) 
  {Flag++;// System.out.println("25");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD500"),
        prop.getAll().get("VLR500"),
        crdetailsObj.getAccountNo(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getCurrencyOfCredit()==null)
  {Flag++;// System.out.println("26");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CurrencyOfCredit>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCurrencyOfCredit()!=null && !crcurrency.matcher(crdetailsObj.getCurrencyOfCredit()).matches()) 
  {Flag++;// System.out.println("27");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD510"),
        prop.getAll().get("VLR510"),
        crdetailsObj.getCurrencyOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }  
  
  if(crdetailsObj.getCurrencyOfCredit()==null)
  {Flag++;// System.out.println("27");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CurrencyOfCredit>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCurrencyOfCredit()!=null && !crcurrency.matcher(crdetailsObj.getCurrencyOfCredit()).matches()) 
  {Flag++;// System.out.println("28");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD510"),
        prop.getAll().get("VLR510"),
        crdetailsObj.getCurrencyOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }  

  if(crdetailsObj.getCreditType()==null)
  {Flag++;// System.out.println("29");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CreditType>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCreditType()!=null && !crcredittype.matcher(crdetailsObj.getCreditType()).matches()) 
  {Flag++;// System.out.println("30");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD520"),
        prop.getAll().get("VLR520"),
        crdetailsObj.getCreditType(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getInitialAmountOfCredit()==null)
  {Flag++;// System.out.println("31");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<InitialAmountOfCredit>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getInitialAmountOfCredit()!=null && !crmebleg.matcher(crdetailsObj.getInitialAmountOfCredit()).matches()) 
  {Flag++;// System.out.println("32");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD530"),
        prop.getAll().get("VLR530"),
        crdetailsObj.getInitialAmountOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getCreditLineAmount()==null)
  {Flag++;// System.out.println("33");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CreditLineAmount>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCreditLineAmount()!=null && !crmebleg.matcher(crdetailsObj.getCreditLineAmount()).matches()) 
  {Flag++;// System.out.println("34");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD540"),
        prop.getAll().get("VLR540"),
        crdetailsObj.getCreditLineAmount(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getDisoutAmountOfCredit()==null)
  {Flag++;// System.out.println("35");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DisoutAmountOfCredit>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDisoutAmountOfCredit()!=null && !crmebleg.matcher(crdetailsObj.getDisoutAmountOfCredit()).matches()) 
  {Flag++;// System.out.println("36");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD550"),
        prop.getAll().get("VLR550"),
        crdetailsObj.getDisoutAmountOfCredit() ,
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getAnnualInterestRate()==null)
  {Flag++;// System.out.println("37");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<AnnualInterestRate>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getAnnualInterestRate()!=null && !crmebleg.matcher(crdetailsObj.getAnnualInterestRate().trim()).matches()) 
  {Flag++;// System.out.println("38");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD560"),
        prop.getAll().get("VLR560"),
        crdetailsObj.getAnnualInterestRate(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getPurposeOfCredit()==null)
  {Flag++;// System.out.println("39");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<PurposeOfCredit>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getPurposeOfCredit()!=null && !crpurposeofcredit.matcher(crdetailsObj.getPurposeOfCredit()).matches()) 
  {Flag++;// System.out.println("40");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD570"),
        prop.getAll().get("VLR570"),
        crdetailsObj.getPurposeOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getCreditPeriodInMonths()==null)
  {Flag++;// System.out.println("41");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CreditPeriodInMonths>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCreditPeriodInMonths()!=null && !crcreditperiodinmonths.matcher(crdetailsObj.getCreditPeriodInMonths()).matches()) 
  {//Flag++;// System.out.println("42");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKOD580"),
//        prop.getAll().get("VLR580"),
//        crdetailsObj.getCreditPeriodInMonths(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getDateOfGrant()==null)
  {Flag++;// System.out.println("43");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DateOfGrant>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDateOfGrant()!=null && !date.matcher(crdetailsObj.getDateOfGrant()).matches()) 
  {Flag++;// System.out.println("44");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD590"),
        prop.getAll().get("VLR590"),
        crdetailsObj.getDateOfGrant(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getDueTimeFirstContract()==null)
  {Flag++;// System.out.println("45");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DueTimeFirstContract>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDueTimeFirstContract()!=null && !date.matcher(crdetailsObj.getDueTimeFirstContract()).matches()) 
  {Flag++;// System.out.println("46");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD600"),
        prop.getAll().get("VLR600"),
        crdetailsObj.getDueTimeFirstContract(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getDueTimeLastContract()==null)
  {Flag++;// System.out.println("47");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DueTimeLastContract>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDueTimeLastContract()!=null && !date.matcher(crdetailsObj.getDueTimeLastContract()).matches()) 
  {Flag++;// System.out.println("47");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD610"),
        prop.getAll().get("VLR610"),
        crdetailsObj.getDueTimeLastContract(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getLastPaymentDate()==null)
  {Flag++;// System.out.println("48");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<LastPaymentDate>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if((crdetailsObj.getLastPaymentDate()!=null && crdetailsObj.getLastPaymentDate()!="")&& !crlastpaymentdate.matcher(crdetailsObj.getLastPaymentDate()).matches()) 
  {Flag++;// System.out.println("49");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD620"),
        prop.getAll().get("VLR620"),
        crdetailsObj.getLastPaymentDate(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if(crdetailsObj.getMonthlyPaymentAmount()==null)
  {Flag++;// System.out.println("50");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<MonthlyPaymentAmount>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getMonthlyPaymentAmount()!=null && !crmebleg.matcher(crdetailsObj.getMonthlyPaymentAmount()).matches()) 
  {Flag++;// System.out.println("51");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD630"),
        prop.getAll().get("VLR630"),
        crdetailsObj.getMonthlyPaymentAmount(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

//  if(crdetailsObj.getMonthlyPaymentAmount()==null)
//  {Flag++;// System.out.println("51+");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKODXML")+"<MonthlyPaymentAmount>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
//  }
//  else if(crdetailsObj.getMonthlyPaymentAmount()!=null && !crmebleg.matcher(crdetailsObj.getMonthlyPaymentAmount()).matches()) 
//  {Flag++;// System.out.println("52");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKOD630"),
//        prop.getAll().get("VLR630"),
//        crdetailsObj.getMonthlyPaymentAmount(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
//  }
//
//  if(crdetailsObj.getMonthlyPaymentAmount()==null)
//  {Flag++;// System.out.println("53");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKODXML")+"<MonthlyPaymentAmount>",
//        prop.getAll().get("VLRXML"),
//        "null",
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
//  }
//  else if(crdetailsObj.getMonthlyPaymentAmount()!=null && !crmebleg.matcher(crdetailsObj.getMonthlyPaymentAmount()).matches()) 
//  {Flag++;// System.out.println("53+");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKOD630"),
//        prop.getAll().get("VLR630"),
//        crdetailsObj.getMonthlyPaymentAmount(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
//  }

  if(crdetailsObj.getDaysMainSumIsOverdue()==null)
  {Flag++;// System.out.println("54");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DaysMainSumIsOverdue>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDaysMainSumIsOverdue()!=null && !digit.matcher(crdetailsObj.getDaysMainSumIsOverdue()).matches()) 
  {Flag++;// System.out.println("55");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD640"),
        prop.getAll().get("VLR640"),
        crdetailsObj.getDaysMainSumIsOverdue(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
  if(crdetailsObj.getDaysInterestIsOverdue()==null)
  {Flag++;// System.out.println("56");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<DaysInterestIsOverdue>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getDaysInterestIsOverdue()!=null && !digit.matcher(crdetailsObj.getDaysInterestIsOverdue()).matches()) 
  {Flag++;// System.out.println("57");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD650"),
        prop.getAll().get("VLR650"),
        crdetailsObj.getDaysInterestIsOverdue(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if(crdetailsObj.getOiaForRepperiod()==null)
  {Flag++;// System.out.println("58");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<OiaForRepperiod>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getOiaForRepperiod()!=null && !crmebleg.matcher(crdetailsObj.getOiaForRepperiod()).matches()) 
  {Flag++;// System.out.println("59");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD660"),
        prop.getAll().get("VLR660"),
        crdetailsObj.getOiaForRepperiod(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if(crdetailsObj.getNumberOfProlongs()==null)
  {Flag++;// System.out.println("60");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<NumberOfProlongs>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getNumberOfProlongs()!=null && !digit.matcher(crdetailsObj.getNumberOfProlongs()).matches()) 
  {Flag++;// System.out.println("61");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD680"),
        prop.getAll().get("VLR680"),
        crdetailsObj.getDaysInterestIsOverdue(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if(crdetailsObj.getCreditClassCode()==null)
  {Flag++;// System.out.println("62");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CreditClassCode>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCreditClassCode()!=null && !crclasscode.matcher(crdetailsObj.getCreditClassCode()).matches()) 
  {Flag++;// System.out.println("63");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD690"),
        prop.getAll().get("VLR690"),
        crdetailsObj.getCreditClassCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }

  if(crdetailsObj.getCreditStatusCode()==null)
  {Flag++;// System.out.println("64");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CreditStatusCode>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  else if(crdetailsObj.getCreditStatusCode()!=null && !crstatuscode.matcher(crdetailsObj.getCreditStatusCode()).matches()) 
  {Flag++;// System.out.println("65");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD700"),
        prop.getAll().get("VLR700"),
        crdetailsObj.getCreditStatusCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
  }
  
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/**********************Girov Məlumatlarının yoxlanması******************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/

  if(objColl !=null)
  {
  if( objColl.getCollateralTypeCode()==null)
  {Flag++;// System.out.println("66");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKODXML")+"<CollateralTypeCode>",
        prop.getAll().get("VLRXML"),
        "null",
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
      
  }
  else if(objColl.getCollateralTypeCode()!=null && !crcollateraltypecode.matcher(objColl.getCollateralTypeCode()).matches())
  {Flag++;// System.out.println("67");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD900"),
        prop.getAll().get("VLR900"),
        objColl.getCollateralTypeCode(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
      
  }
  }
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************Məntiqi yoxlamalar******************************************/
/***********************************************************************************************/
/***********************************************************************************************/
/***********************************************************************************************/

     if(crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
        crdetailsObj.getInitialAmountOfCredit()!=null && crdetailsObj.getInitialAmountOfCredit()!="" &&
        crdetailsObj.getCreditType().contentEquals("001") && Float.valueOf(crdetailsObj.getInitialAmountOfCredit()) <=0)
     {Flag++;// System.out.println("68");
//         System.out.println(" VLR 800 Kredit tipi Kredit olduqda onun Ilkin meblegi sıfırdan olmalıdır ");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD800"),
        prop.getAll().get("VLR800"),
        crdetailsObj.getInitialAmountOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
         
     } 
     
      if (crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
              crdetailsObj.getCreditLineAmount()!=null && crdetailsObj.getCreditLineAmount()!="" &&
              crdetailsObj.getCreditType().contentEquals("001") &&  Float.valueOf(crdetailsObj.getCreditLineAmount())>0)
     {Flag++;// System.out.println("69");
        //System.out.println(" VLR 801 Kredit tipi Kredit olduqda Xettin ve ya Kartin Ilkin meblegi musbet deyer ola bilmez ");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD801"),
        prop.getAll().get("VLR801"),
        crdetailsObj.getCreditLineAmount(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");

     }
      if (crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
              crdetailsObj.getInitialAmountOfCredit()!=null && crdetailsObj.getInitialAmountOfCredit()!="" &&
              crdetailsObj.getDisoutAmountOfCredit()!=null && crdetailsObj.getDisoutAmountOfCredit()!="" &&
              crdetailsObj.getCreditType().contentEquals("001") && 
              (Float.valueOf(crdetailsObj.getInitialAmountOfCredit())< Float.valueOf(crdetailsObj.getDisoutAmountOfCredit())))
     {Flag++;// System.out.println("70");
      //   System.out.println(" VLR 802 Kredit tipi Kredit olduqda Kreditin qaliq meblegi onun Ilkin mebleginden boyuk ola bilmez");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD802"),
        prop.getAll().get("VLR802"),
        crdetailsObj.getInitialAmountOfCredit()+"<"+crdetailsObj.getDisoutAmountOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
         
     }
      
      if (crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
          crdetailsObj.getInitialAmountOfCredit()!=null && crdetailsObj.getInitialAmountOfCredit()!="" &&    
          (crdetailsObj.getCreditType().contentEquals("002") || 
           crdetailsObj.getCreditType().contentEquals("003")) &&  
           Float.valueOf(crdetailsObj.getInitialAmountOfCredit())>0)
     {Flag++;// System.out.println("71");
       //  System.out.println(" VLR 803 Kredit tipi kredit xetti ve ya kartı olduqda kreditin ilkin məbləği sıfır olmalıdır");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD803"),
        prop.getAll().get("VLR803"),
        crdetailsObj.getInitialAmountOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
         
     }
      
      if (crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
          crdetailsObj.getCreditLineAmount()!=null && crdetailsObj.getCreditLineAmount()!="" &&
          (crdetailsObj.getCreditType().contentEquals("002") || 
           crdetailsObj.getCreditType().contentEquals("003")) && 
           Float.valueOf(crdetailsObj.getCreditLineAmount())<=0)
     {Flag++;// System.out.println("72");
      //   System.out.println(" VLR 804 Kredit tipi kredit xətti və ya kartı olduqda onun ilkin məbləği sıfırdan böyük olmalıdır ");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD804"),
        prop.getAll().get("VLR804"),
        crdetailsObj.getCreditLineAmount(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
     }
      
     if(crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
             crdetailsObj.getCreditType()!=null && crdetailsObj.getCreditType()!="" &&
             (crdetailsObj.getCreditType().contentEquals("002") || crdetailsObj.getCreditType().contentEquals("003")) && 
             Float.parseFloat(crdetailsObj.getCreditLineAmount())<Float.valueOf(crdetailsObj.getDisoutAmountOfCredit()))
     {Flag++;// System.out.println("73");
       //  System.out.println(" VLR 805 Kredit tipi kredit xətti və ya kartı olduqda onun qalıq məbləği ilkin məbləğindən böyük ola bilməz");
        recWrDG.RecordingGate(objColl.getSaygac(),
        prop.getAll().get("VLRKOD805"),
        prop.getAll().get("VLR805"),
        crdetailsObj.getCreditLineAmount()+"<"+crdetailsObj.getDisoutAmountOfCredit(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");
     }
          
     
     //System.out.println(" Date of first contract "+crdetailsObj.getDueTimeFirstContract());
     
//   System.out.println("Granted_on "+df.format(granted_on));
//   System.out.println("First_contract_on "+df.format(first_contract_no));
//   System.out.println("Last_contract_on "+df.format(last_contract_on));
//   System.out.println("Last_paymant_date "+df.format(last_payment_date));
   
   if (crdetailsObj.getDateOfGrant()!=null && crdetailsObj.getDueTimeFirstContract()!=null &&
      (date.matcher(crdetailsObj.getDateOfGrant()).matches() && date.matcher(crdetailsObj.getDueTimeFirstContract()).matches())
           )
   {granted_on=df.parse(crdetailsObj.getDateOfGrant()); first_contract_no=df.parse(crdetailsObj.getDueTimeFirstContract());
     if(  
        granted_on.after(first_contract_no)
        )
     {Flag++;// System.out.println("74");
//         System.out.println(" VLR810 Granted_on > First_contract******* Granted_on: "+df.format(granted_on)+" **** FirstContract: "+df.format(first_contract_no));
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD810"),
        prop.getAll().get("VLR810"),
        "Granted_on: "+df.format(granted_on)+" **** FirstContract: "+df.format(first_contract_no),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");         
     }
     
   }
   
   if(crdetailsObj.getDateOfGrant()!=null && crdetailsObj.getDueTimeLastContract()!=null &&
     (date.matcher(crdetailsObj.getDateOfGrant()).matches() && date.matcher(crdetailsObj.getDueTimeLastContract()).matches()))
   {last_contract_on=df.parse(crdetailsObj.getDueTimeLastContract());
     if(granted_on.after(last_contract_on))
     {Flag++;// System.out.println("75");
//         System.out.println("VLR810_2 Granted_no > Last_contract ******* Granted_on:"+df.format(granted_on)+" **** last_contract_on: "+df.format(last_contract_on));
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD810_2"),
        prop.getAll().get("VLR810_2"),
        "Granted_on: "+df.format(granted_on)+" **** last_contract_on: "+df.format(last_contract_on),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");         
         
     }
   }
   
   if(crdetailsObj.getDueTimeFirstContract()!=null && crdetailsObj.getDueTimeLastContract()!=null &&
     (date.matcher(crdetailsObj.getDueTimeFirstContract()).matches() && date.matcher(crdetailsObj.getDueTimeLastContract()).matches()))
   {last_contract_on=df.parse(crdetailsObj.getDueTimeLastContract()); first_contract_no=df.parse(crdetailsObj.getDueTimeFirstContract());
     if(first_contract_no.after(last_contract_on))
     {Flag++;// System.out.println("76");
// System.out.println("VLR811 First_conract > Last_contract_on **** last_contract_on: "+df.format(last_contract_on)+" **** first_contract_on: "+df.format(first_contract_no);
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD811"),
        prop.getAll().get("VLR811"),
        "First_contract_on: "+df.format(first_contract_no)+" **** last_contract_on: "+df.format(last_contract_on),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");         
     }
   }
   
    if(crdetailsObj.getDateOfGrant()!=null && crdetailsObj.getLastPaymentDate()!=null &&
      (date.matcher(crdetailsObj.getDateOfGrant()).matches() && date.matcher(crdetailsObj.getLastPaymentDate()).matches()))
    {//System.out.println("DFG : "+crdetailsObj.getDateOfGrant()+" LPD: "+crdetailsObj.getLastPaymentDate());
        last_payment_date=df.parse(crdetailsObj.getLastPaymentDate()); granted_on=df.parse(crdetailsObj.getDateOfGrant());
     if(last_payment_date.before(granted_on))
     {Flag++;// System.out.println("77");
    //System.out.println(" VLR813 Granted_on  > Last_paymant_date *** Granted_on: "+df.format(granted_on)+" **** last_payment_date: "+df.format(last_payment_date));
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD813"),
        prop.getAll().get("VLR813"),
        "Granted_on: "+df.format(granted_on)+" **** last_payment_date: "+df.format(last_payment_date),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null");         
     }
    }
    
    if(crdetailsObj.getDisoutAmountOfCredit()!=null && crdetailsObj.getOiaForRepperiod()!=null &&
       crdetailsObj.getDisoutAmountOfCredit()!="" && crdetailsObj.getOiaForRepperiod()!="" ){
       
    if(crdetailsObj.getCreditStatusCode()!=null && crstatuscode.matcher(crdetailsObj.getCreditStatusCode()).matches() &&
       Float.parseFloat(crdetailsObj.getDisoutAmountOfCredit())<0 || Float.parseFloat(crdetailsObj.getOiaForRepperiod())<0
            )
    {Flag++;// System.out.println("78");
//    System.out.println(" VLR823 Kreditin qalıq və faiz borcu sıfırdan fərqlidirsə Tam ödənilmiş statusunda(001) göndərilə bilməz ");
        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
        prop.getAll().get("VLRKOD823"),
        prop.getAll().get("VLR823"),
        "Qalıq borcu : "+crdetailsObj.getDisoutAmountOfCredit()+" **** Faiz borcu: "+crdetailsObj.getOiaForRepperiod(),
        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null"); 
    }

    }
     
     //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     //System.out.println("Calendar privet "+df.format(cal.getTime()));
     
     if(crdetailsObj.getDaysMainSumIsOverdue()!=null &&  crdetailsObj.getDaysMainSumIsOverdue()!="" &&
        crdetailsObj.getDaysInterestIsOverdue()!=null && crdetailsObj.getDaysInterestIsOverdue()!="" &&     
        crdetailsObj.getDisoutAmountOfCredit()!=null && crdetailsObj.getDisoutAmountOfCredit()!="" &&     
        crdetailsObj.getOiaForRepperiod()!=null && crdetailsObj.getOiaForRepperiod()!="" &&
        crdetailsObj.getDueTimeLastContract()!=null && date.matcher(crdetailsObj.getDueTimeLastContract()).matches()      
        ) 
     {//Flag++;// System.out.println("79");
	   
    if ((Float.parseFloat(crdetailsObj.getDisoutAmountOfCredit())>0 || Float.parseFloat(crdetailsObj.getOiaForRepperiod())>0) &&
        (date.matcher(crdetailsObj.getDueTimeLastContract()).matches() && last_contract_on.before(cal.getTime()))&&
        (Math.round(Float.parseFloat(crdetailsObj.getDaysMainSumIsOverdue()))<=0||Math.round(Float.parseFloat(crdetailsObj.getDaysInterestIsOverdue()))<=0)
        )  
    {//Flag++;// System.out.println("80");
//        System.out.println("VLR825 ");
//        recWrDG.RecordingGate(crdetailsObj.getSaygac(),
//        prop.getAll().get("VLRKOD825"),
//        prop.getAll().get("VLR825"),
//        "Qalıq borcu : "+crdetailsObj.getDisoutAmountOfCredit()+" **** Faiz borcu: "+crdetailsObj.getOiaForRepperiod(),
//        (crdetailsObj.getAccountNo()!=null) ? crdetailsObj.getAccountNo() : "null"); 
        
    }
    
     }
      //System.out.println(" Flag before: "+Flag+" Saygac "+crdetailsObj.getSaygac());
     if(Flag>0)
     {
         Flag=0;
         //System.out.println(" Flag after : "+Flag);

         makeXml.CombineObjects(borrObj, guaranObj, crdetailsObj,objColl, objHeader,tag_name);
     } else if (tag_name.contentEquals("Credits"))
     {
         makeXml.CombineObjects(borrObj, guaranObj, crdetailsObj,objColl, objHeader,tag_name );
     }
 

  }
  
  
//    public void Errors() {
//////      System.out.println("Errorrs size "+WrongDataList.size()
//////              + " to_String : "+WrongDataList.toString()
////      );
//      //for (WrongData wd : WrongDataList)
// //     {
// //         System.out.println(" WD Account:"+wd.getAccount_no()+" KOD : "+wd.getVLRkod()+" WrData :"+wd.getWrong_data());
// //     }
//      
//      //System.out.println(" Err0 count : "+WrongDataList.size());
//      
//      
//
//            if(dGuarantees.size()>0)
//            {
//              String max=dGuarantees.get(0).getSaygac();
//      int t=0;
//      for (int i = 1; i<dGuarantees.size(); i++ )
//      {
//                   
//          if(max!=dGuarantees.get(i).getSaygac())
//          { 
//              max=dGuarantees.get(i).getSaygac();
//          t=0;
//              
//          }
//          else if(max==dGuarantees.get(i).getSaygac())
//          {
//              t++;
//              if(t>20)
//              {
////                System.out.println(" Borrower :"+dBorrower.get(Integer.parseInt(dGuarantees.get(i).getSaygac())).getId()
////                +" Name :"+dBorrower.get(Integer.parseInt(dGuarantees.get(i).getSaygac())).getName()
////                +" Zamin : "+dGuarantees.get(i).getId()
////                +"  Account : "+dCreditDetails.get(Integer.parseInt(dGuarantees.get(i).getSaygac())).getAccountNo());
//                t=0;
//                   //break;
//              }
//                  
//              
//          }
//          
//      }
//          
//      }
//            
//      
//  }

    
}

