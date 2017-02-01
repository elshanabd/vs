package Parsing;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */


import CreditParts.Header;
import CreditParts.Guarantees;
import CreditParts.CreditDetails;
import CreditParts.Collateral;
import CreditParts.Borrower;

import Rules.GeneralRulesCheckup;
import Rules.XMLmaker;
import WriteToFiles.OutputToFile;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

//import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author elshan
 */
public class Handler2 extends DefaultHandler{
    
    private int creditSay=0;
    private int endCSay;
    private String CountYes;
    private String temp;
    private boolean t=false;
    private boolean f=false;
    public String str="Privet";
     int g=0;
     float c=0;
     int closed_credits;
     int result;
     File file;
    
    JFrame barframe = new JFrame("Məlumatın emalı və fayıllara yazılması Prosessi");
    //barframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container content = barframe.getContentPane();
    final JProgressBar progressBar = new JProgressBar();
    
    private Header objHeader ;
    public ArrayList<Header> listHeader = new ArrayList<Header>();
    private Collateral objColl;
    public ArrayList<Collateral> listCollateral = new ArrayList<Collateral>();
    private CreditDetails objCDetails;
    public ArrayList<CreditDetails> listCreditDetails = new ArrayList<CreditDetails>();
    private Borrower objBorr;
    public ArrayList<Borrower> listBorrower = new ArrayList<Borrower>();
    private Guarantees objGuarant;
    public ArrayList<Guarantees> listGuarantees = new ArrayList<Guarantees>();
    
   GeneralRulesCheckup genCheckUp= new GeneralRulesCheckup();
   OutputToFile otf=new OutputToFile (); 
   XMLmaker XmlMake=new XMLmaker();

     

 
 public void getHeaderInfo(){
     
//     System.out.println("Count of  the Header into in bank '" + listHeader.size()  + "'.");
//     
//              Iterator<Header> it = listHeader.iterator();
//              while (it.hasNext()) {
//              System.out.println("ListHeader :  "+it.next().toString());
//              }
              /*
              System.out.println("Bank ID :  "+listHeader.get(0).getBankId());
              System.out.println("Bank Name :  "+listHeader.get(0).getBankName());
              System.out.println("Report Date :  "+listHeader.get(0).getReportDate());
              */
              
             
 }
  
 
 public void getCollateralinfo(){
     
//      Iterator<Collateral> itc = listCollateral.iterator();
//              while (itc.hasNext()) {
//              System.out.println("ListColl :  "+itc.next().toString());
//              }
      //for (int f=0; f<listCollateral.size();f++){
          //System.out.println("Collateral : "+listCollateral.get(f));
          //System.out.println("Collateral : "+listCollateral.get(f).getMarketValue());
          
      //}
 
 }
    
 public void getCreditDetailsinfo(){
     
//      Iterator<CreditDetails> itcd = listCreditDetails.iterator();
//              while (itcd.hasNext()) {
//              System.out.println("ListCreditDatails :  "+itcd.next().toString());
//              } 
         
 }
 
 public void getBorrowerinfo(){
     
//      Iterator<Borrower> itcd = listBorrower.iterator();
//              while (itcd.hasNext()) {
//              System.out.println("ListBorrower :  "+itcd.next().toString());
//              }
              for (int u=0; u<listBorrower.size();u++)
              {
                  //System.out.println("out put : "+listBorrower.get(u));
                  String chararray=listBorrower.get(u).getId();
                  System.out.println("chararray : "+chararray
                          +" name "+listBorrower.get(u).getPinCode()
                  +" BDate "+listBorrower.get(u).getDateOfBirth());
              }              
 }
 
  
  public void getGuaranteesinfo(){
    
      
      //System.out.println("Guaranter size : "+listGuarantees.size());
     for (int i=0; i<listGuarantees.size();i++){ 
         //System.out.println("Size Array "+listGuarantees.get(i)); 
         //System.out.println("Guarantees : "+listGuarantees.get(i).getId()+"  name : "+listGuarantees.get(i).getName());
     }
     //System.out.println("Char out: "+listGuarantees.get(0).getSaygac()+"  name out : "+listGuarantees.get(0).getName());
     
     
//      Iterator<Guarantees> itcd = listGuarantees.iterator();
//              while (itcd.hasNext()) {
//              System.out.println("ListGuarantees :  "+itcd.next().toString());
//              }  
 }
 
    @Override
     public void startDocument() throws SAXException {
         System.out.println("Start Document....");
        
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document....");
//        cr=listBorrower;
      //genCheckUp.Errors();
      
      
        
    }

    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
    throws SAXException {
        //System.out.println("Start Element...."+ qName);
        temp=""; 
        if(qName.contentEquals("Credit")){ 
             
            CountYes=String.valueOf(creditSay);
        
        }
        
        if(qName.contentEquals("Header")){objHeader =new Header();}
        if(qName.contentEquals("Collateral")){objColl =new Collateral();}
        if(qName.contentEquals("Borrower")){objBorr =new Borrower();f=true;}
        if(qName.contentEquals("Guarantee")){ objGuarant =new Guarantees(); t=true; f=false ;endCSay++;}
        if(qName.contentEquals("AccountNo")){objCDetails =new CreditDetails();}
     
    
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    throws SAXException {
        
        //System.out.println("End Element...."+qName);
        
           if(qName.contentEquals("Header")){ listHeader.add(objHeader); }
        else if (qName.equalsIgnoreCase("BankID")) {
                     objHeader.setBankId(temp);
              } else if (qName.equalsIgnoreCase("BankName")) {
                     
                     temp=temp.replaceAll("[\"\"-+.^:,?]","");
                      System.out.println("ad : "+temp);
                      objHeader.setBankName(temp);
              } else if (qName.equalsIgnoreCase("ReportingDate")) {                
                   objHeader.setReportDate(temp); 
                    otf.HeaderInfo(objHeader);
                                  
                    try {
                   otf.setFileName(objHeader.getBankId().trim()+objHeader.getBankName().trim());
                  //otf.createNewFile();
                  
               } //listHeader.clear();
               catch (IOException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               }
               
              }
       

           while ( creditSay>g  ){
        //if(creditSay>0){
            try {
                g++; 
                //System.out.println("Credit Say while :"+creditSay+"  g  "+g);
                
         progressBar.setStringPainted(true);
         Border border = BorderFactory.createTitledBorder("Parsed lines..."+creditSay);
         progressBar.setBorder(border);
         content.add(progressBar, BorderLayout.NORTH);
         final int p=creditSay%99;
               
                
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        progressBar.setValue(p);
                        
                    }
                });
                
                java.lang.Thread.sleep(0);
                barframe.setSize(400, 100);
                barframe.setVisible(true);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    //}
            if (creditSay==g&&qName.contentEquals("CreditInfo"))
            {   
                c=XmlMake.getCounter();
                barframe.dispose();
                
                String[] options = { "Hesabatı Göstər" };
                if(c==0) options[0]="Səhv qeydə alınmadı";
                result = JOptionPane.showOptionDialog(null, 
                        "File : ["+otf.takeFilePath()+
                        "] \n"+
                        "Result : ["+g+"]  sayda kredit məlumatı emal olundu .\n ["+
                                closed_credits+"] sayda bağlı kredit göndərilmişdir. \n ["+
                                XmlMake.getCounter()+"] sayda səhv aşkarlandı .\n Portfelin ["+
                                (c/(float)g)*100+"] faizi səhvdir. ",
                            //    +otf.takeFilePath().substring(0, otf.takeFilePath().length()-3).concat("xlsx") 
                        "Faylın emalı başa çatdı" ,JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE , null , options,
                        options[0]
              );
              
              
                System.out.println(" Portfel : "+(c/(float)g)*100);
                System.out.println(" Result : "+result);
                
                if(result==0){
                            if(!Desktop.isDesktopSupported()){
                            System.out.println("Desktop is not supported");
                            return;
                            }
                           // otf.setFileName(otf.takeFilePath().length());
                   file = new File(otf.takeFilePath().substring(0, otf.takeFilePath().length()-3).concat("xlsx"));
                             Desktop desktop = Desktop.getDesktop();
              if(file.exists()){
                  try {
                   desktop.open(file);
                            } catch (IOException ex) {
                                Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
                            }     
              } //else { JOptionPane.showMessageDialog(null, "Portfel sehvsizdir");}
                }
                
                
                XmlMake.setCounter(0);
                
               try {
                   otf.setFileName("");
                   
               } catch (IOException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               }
                
            }
    

   
           
             if(qName.contentEquals("Borrower")){
                 f=true; 
                 listBorrower.add(objBorr); 
             objBorr.setSaygac(CountYes);}
        else if(qName.equalsIgnoreCase("id")&& f) {
                     objBorr.setId(temp); 
              }else if (qName.equalsIgnoreCase("name")&& f) {
                     objBorr.setName(temp); 
              }else if (qName.equalsIgnoreCase("CountryCode")&& f) {
                     objBorr.setCountryCode(temp); 
              }else if (qName.equalsIgnoreCase("BankruptcyStatus")&& f) {
                     objBorr.setBankruptcyStatus(temp);
              }else if (qName.equalsIgnoreCase("DateOfBirth")&& f) {
                     objBorr.setDateOfBirth(temp); 
              }else if (qName.equalsIgnoreCase("PlaceOfBirth")&& f) {
                     objBorr.setPlaceOfBirth(temp); 
              }else if (qName.equalsIgnoreCase("PinCode")&& f) {
                     objBorr.setPinCode(temp); 
              }listBorrower.clear();
                     
                
                
         if(qName.equalsIgnoreCase("Guarantee")) { t=false; f=true; 
         listGuarantees.add(objGuarant); 
                      objGuarant.setSaygac(CountYes);}
         else if (qName.equalsIgnoreCase("id")&& t) {
           //  System.out.println("Value_id...... " +creditSay+" ===t "+temp);
            objGuarant.setId(temp);
              }else if (qName.equalsIgnoreCase("name")&&t) {
                 objGuarant.setName(temp);
              }  else if (qName.equalsIgnoreCase("CountryCode")&&t) {
                 objGuarant.setCountryCode(temp);
              }else if (qName.equalsIgnoreCase("DateOfBirth")&&t) {
                 objGuarant.setDateOfBirth(temp);
              }else if (qName.equalsIgnoreCase("PlaceOfBirth")&&t) {
                 objGuarant.setPlaceOfBirth(temp);  
              }else if (qName.equalsIgnoreCase("PinCode")&&t) {
                 objGuarant.setPinCode(temp);   
              }//listGuarantees.clear();
   
        
        
        
        
              if(qName.contentEquals("AccountNo")){ listCreditDetails.add(objCDetails); 
              objCDetails.setSaygac(CountYes);
                     objCDetails.setAccountNo(temp);
              }else  if(qName.equalsIgnoreCase("CurrencyOfCredit")){ 
                     objCDetails.setCurrencyOfCredit(temp);
              }else if (qName.equalsIgnoreCase("CreditType")) {
                     objCDetails.setCreditType(temp);
              }else if (qName.equalsIgnoreCase("InitialAmountOfCredit")) {
                     objCDetails.setInitialAmountOfCredit(temp);
              }else if (qName.equalsIgnoreCase("CreditLineAmount")) {
                     objCDetails.setCreditLineAmount(temp);
              }else if (qName.equalsIgnoreCase("DisoutAmountOfCredit")) {
                     objCDetails.setDisoutAmountOfCredit(temp);
              }else if (qName.equalsIgnoreCase("AnnualInterestRate")) {
                     objCDetails.setAnnualInterestRate(temp);
              }else if (qName.equalsIgnoreCase("PurposeOfCredit")) {
                     objCDetails.setPurposeOfCredit(temp);
              }else if (qName.equalsIgnoreCase("CreditPeriodInMonths")) {
                     objCDetails.setCreditPeriodInMonths(temp);
              }else if (qName.equalsIgnoreCase("DateOfGrant")) {
                     objCDetails.setDateOfGrant(temp);
              }else if (qName.equalsIgnoreCase("DueTimeFirstContract")) {
                     objCDetails.setDueTimeFirstContract(temp);
              }else if (qName.equalsIgnoreCase("DueTimeLastContract")) {
                     objCDetails.setDueTimeLastContract(temp);
              }else if (qName.equalsIgnoreCase("LastPaymentDate")) {
                     objCDetails.setLastPaymentDate(temp);
              }else if (qName.equalsIgnoreCase("MonthlyPaymentAmount")) {
                     objCDetails.setMonthlyPaymentAmount(temp);
              }else if (qName.equalsIgnoreCase("DaysMainSumIsOverdue")) {
                     objCDetails.setDaysMainSumIsOverdue(temp);
              }else if (qName.equalsIgnoreCase("DaysInterestIsOverdue")) {
                     objCDetails.setDaysInterestIsOverdue(temp);
              }else if (qName.equalsIgnoreCase("OiaForRepperiod")) {
                     objCDetails.setOiaForRepperiod(temp);
              }else if (qName.equalsIgnoreCase("NumberOfProlongs")) {
                     objCDetails.setNumberOfProlongs(temp);
              }else if (qName.equalsIgnoreCase("CreditStatusCode")) {
                     objCDetails.setCreditStatusCode(temp);
              }else if (qName.equalsIgnoreCase("CreditClassCode")) {
                     objCDetails.setCreditClassCode(temp);
              }listCreditDetails.clear();

            
        if(qName.contentEquals("Collateral")){ listCollateral.add(objColl);objColl.setSaygac(CountYes);  }
        else if (qName.equalsIgnoreCase("CollateralTypeCode")) {
                     objColl.setCollateralTypeCode(temp);
              } else if (qName.equalsIgnoreCase("AnyInfoToDisting")) {
                     objColl.setAnyInfoToDisting(temp);
              } else if (qName.equalsIgnoreCase("MarketValue")) {
                     objColl.setMarketValue(temp);
              }else if (qName.equalsIgnoreCase("RegistryNo")) {
                     objColl.setRegistryAgency(temp);
              } else if (qName.equalsIgnoreCase("RegistryDate")) {
                     objColl.setRegistryDate(temp);
              } else if (qName.equalsIgnoreCase("RegistryAgency")) {
                     objColl.setRegistryAgency(temp);
              } listCollateral.clear();

      if(qName.contentEquals("Credit")){
          creditSay++;
               try {
                   if(!objCDetails.getCreditStatusCode().contentEquals("001")){
          genCheckUp.ResultsCheck(objBorr, listGuarantees, objCDetails, objColl, objHeader, "Credit");
                   } else { 
closed_credits++;}

               } catch (IOException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ParseException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InvalidFormatException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               }
               listGuarantees.clear();
               listBorrower.clear();
               listCreditDetails.clear();
               listCollateral.clear(); 
      
      }   else
      
      if(qName.contentEquals("Credits"))
      {
        System.out.println("in Credits");
                       try {

          genCheckUp.ResultsCheck(objBorr, listGuarantees, objCDetails, objColl, objHeader, "Credits");
          

               } catch (IOException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ParseException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InvalidFormatException ex) {
                   Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
               }

        
      }
      
      
      
      
      
      
      
      
        
    }

    @Override
    public void characters(char ch[], int start, int length)
    throws SAXException {
       temp=new String(ch , start , length);
        
    if(temp.toString().trim().isEmpty()){}else{
     // System.out.println("Values...."+ temp);
       }
    
    
    
    }

//    public void ignorableWhitespace(char ch[], int start, int length)
//    throws SAXException {
//    }
    
    
    public String  CountCredits(){
    System.out.println("CreditCount : "+creditSay
            +", Guarantee count : "+endCSay
            //+", Count Yes : "+CountYes
            );
    
    return   ""; //(creditSay+" "+endCSay); 
    }
    

    
    
}