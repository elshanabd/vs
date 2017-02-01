/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import CreditParts.Borrower;
import CreditParts.Collateral;
import CreditParts.CreditDetails;
import CreditParts.Guarantees;
import CreditParts.Header;
import CreditParts.Tags;
import Properties.data.rules.ConfigProperties;
import WriteToFiles.OutputToFile;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Elshan.Abdullayev
 */
public class XMLmaker {
    ConfigProperties prop;
    Tags objTags = new Tags();

  OutputToFile Otf= new OutputToFile() ;
  static int t=0;
  static int k=0;
  static int Counter=0;

    public  void setCounter(int Counter) {
        XMLmaker.Counter = Counter;
    }

    public int getCounter() {
        return Counter;
    }
  
  public ArrayList<String> XMLmassiv = new  ArrayList<String>();
  
  
    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
    
    
    
   public void CombineObjects(Borrower borrObj, ArrayList<Guarantees> guaranObj, CreditDetails crdetailsObj ,Collateral objColl, Header objHeader, String tag_name) 
           throws FileNotFoundException
    {
    //System.out.println("CombineObjects Begin .......");
  if (getK()==0)
  { System.out.println("First K Value"+getK());
    objTags.setXmlVersion(prop.getAll().get("tXmlVersion"));
    XMLmassiv.add(objTags.getXmlVersion());
    objTags.setCreditInfo(prop.getAll().get("tLess")+prop.getAll().get("tCreditInfo")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCreditInfo());
    objTags.setHeader(prop.getAll().get("tLess")+prop.getAll().get("tHeader")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getHeader());
    objTags.setBankID(prop.getAll().get("tLess")+prop.getAll().get("tBankID")+prop.getAll().get("tMore")+
            objHeader.getBankId()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tBankID")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getBankID());
    objTags.setBankName(prop.getAll().get("tLess")+prop.getAll().get("tBankName")+prop.getAll().get("tMore")+
            objHeader.getBankName()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tBankName")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getBankName());
    objTags.setReportingDate(prop.getAll().get("tLess")+prop.getAll().get("tReportingDate")+prop.getAll().get("tMore")+
            objHeader.getReportDate()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tReportingDate")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getReportingDate());
    objTags.setHeader(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tHeader")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getHeader());
    objTags.setCredits(prop.getAll().get("tLess")+prop.getAll().get("tCredits")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCredits());
      setK(1); 
  }

if(tag_name.contentEquals("Credit"))
{Counter++;
    //System.out.println("Second K Value"+getK()+" Counter "+Counter); t=1;
    objTags.setCredit(prop.getAll().get("tLess")+prop.getAll().get("tCredit")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCredit());
    objTags.setBorrower(prop.getAll().get("tLess")+prop.getAll().get("tBorrower")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getBorrower());
    objTags.setId(prop.getAll().get("tLess")+prop.getAll().get("tid")+prop.getAll().get("tMore")+
            borrObj.getId()+
            //borrObj.getId()!=null ? borrObj.getId() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tid")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getId());
    objTags.setName(prop.getAll().get("tLess")+prop.getAll().get("tname")+prop.getAll().get("tMore")+
            borrObj.getName()+
            //borrObj.getName()!=null ? borrObj.getName() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tname")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getName());
    objTags.setCountryCode(prop.getAll().get("tLess")+prop.getAll().get("tCountryCode")+prop.getAll().get("tMore")+
            borrObj.getCountryCode()+
            //borrObj.getCountryCode()!=null ? borrObj.getCountryCode() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCountryCode")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCountryCode());
    objTags.setBankruptcyStatus(prop.getAll().get("tLess")+prop.getAll().get("tBankruptcyStatus")+prop.getAll().get("tMore")+
            borrObj.getBankruptcyStatus()+
            //borrObj.getBankruptcyStatus()!=null ? borrObj.getBankruptcyStatus() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tBankruptcyStatus")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getBankruptcyStatus());
    objTags.setDateOfBirth(prop.getAll().get("tLess")+prop.getAll().get("tDateOfBirth")+prop.getAll().get("tMore")+
            borrObj.getDateOfBirth()+
            //borrObj.getDateOfBirth()!=null ? borrObj.getDateOfBirth() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDateOfBirth")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getDateOfBirth());
    objTags.setPlaceOfBirth(prop.getAll().get("tLess")+prop.getAll().get("tPlaceOfBirth")+prop.getAll().get("tMore")+
            borrObj.getPlaceOfBirth()+
            //borrObj.getPlaceOfBirth()!=null ? borrObj.getPlaceOfBirth() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tPlaceOfBirth")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getPlaceOfBirth());
    objTags.setPinCode(prop.getAll().get("tLess")+prop.getAll().get("tPinCode")+prop.getAll().get("tMore")+
            borrObj.getPinCode()+
            //borrObj.getPinCode()!=null ? borrObj.getPinCode() : "null"+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tPinCode")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getPinCode());    
    
    
    if(guaranObj!=null && guaranObj.size()>0)
    {
        //System.out.println("Size Guarantor PPP:"+guaranObj.size());
    objTags.setGuarantees(prop.getAll().get("tLess")+prop.getAll().get("tGuarantees")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getGuarantees());    
         for (int i = 0; i<guaranObj.size();i++)
         {
    objTags.setGuarantee(prop.getAll().get("tLess")+prop.getAll().get("tGuarantee")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getGuarantee());    
    objTags.setId(prop.getAll().get("tLess")+prop.getAll().get("tid")+prop.getAll().get("tMore")+
            guaranObj.get(i).getId()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tid")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getId());
    objTags.setName(prop.getAll().get("tLess")+prop.getAll().get("tname")+prop.getAll().get("tMore")+
            guaranObj.get(i).getName()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tname")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getName());
    objTags.setCountryCode(prop.getAll().get("tLess")+prop.getAll().get("tCountryCode")+prop.getAll().get("tMore")+
            guaranObj.get(i).getCountryCode()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCountryCode")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCountryCode());
    objTags.setDateOfBirth(prop.getAll().get("tLess")+prop.getAll().get("tDateOfBirth")+prop.getAll().get("tMore")+
            guaranObj.get(i).getDateOfBirth()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDateOfBirth")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getDateOfBirth());
    objTags.setPlaceOfBirth(prop.getAll().get("tLess")+prop.getAll().get("tPlaceOfBirth")+prop.getAll().get("tMore")+
            guaranObj.get(i).getPlaceOfBirth()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tPlaceOfBirth")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getPlaceOfBirth());
    objTags.setPinCode(prop.getAll().get("tLess")+prop.getAll().get("tPinCode")+prop.getAll().get("tMore")+
            guaranObj.get(i).getPinCode()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tPinCode")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getPinCode());    
    objTags.setGuarantee(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tGuarantee")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getGuarantee());    
         }
    objTags.setGuarantees(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tGuarantees")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getGuarantees());    
         
    guaranObj=null;
    }
    objTags.setBorrower(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tBorrower")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getBorrower());

    objTags.setAccountNo(prop.getAll().get("tLess")+prop.getAll().get("tAccountNo")+prop.getAll().get("tMore")+
            crdetailsObj.getAccountNo()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tAccountNo")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getAccountNo());
    objTags.setCurrencyOfCredit(prop.getAll().get("tLess")+prop.getAll().get("tCurrencyOfCredit")+prop.getAll().get("tMore")+
            crdetailsObj.getCurrencyOfCredit()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCurrencyOfCredit")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCurrencyOfCredit());
    objTags.setCreditType(prop.getAll().get("tLess")+prop.getAll().get("tCreditType")+prop.getAll().get("tMore")+
            crdetailsObj.getCreditType()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditType")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCreditType());
    objTags.setInitialAmountOfCredit(prop.getAll().get("tLess")+prop.getAll().get("tInitialAmountOfCredit")+prop.getAll().get("tMore")+
            crdetailsObj.getInitialAmountOfCredit()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tInitialAmountOfCredit")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getInitialAmountOfCredit());
    objTags.setCreditLineAmount(prop.getAll().get("tLess")+prop.getAll().get("tCreditLineAmount")+prop.getAll().get("tMore")+
            crdetailsObj.getCreditLineAmount()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditLineAmount")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCreditLineAmount());
    objTags.setDisoutAmountOfCredit(prop.getAll().get("tLess")+prop.getAll().get("tDisoutAmountOfCredit")+prop.getAll().get("tMore")+
            crdetailsObj.getDisoutAmountOfCredit()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDisoutAmountOfCredit")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDisoutAmountOfCredit());
    objTags.setAnnualInterestRate(prop.getAll().get("tLess")+prop.getAll().get("tAnnualInterestRate")+prop.getAll().get("tMore")+
            crdetailsObj.getAnnualInterestRate()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tAnnualInterestRate")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getAnnualInterestRate());
    objTags.setPurposeOfCredit(prop.getAll().get("tLess")+prop.getAll().get("tPurposeOfCredit")+prop.getAll().get("tMore")+
            crdetailsObj.getPurposeOfCredit()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tPurposeOfCredit")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getPurposeOfCredit());
    objTags.setCreditPeriodInMonths(prop.getAll().get("tLess")+prop.getAll().get("tCreditPeriodInMonths")+prop.getAll().get("tMore")+
            crdetailsObj.getCreditPeriodInMonths()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditPeriodInMonths")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCreditPeriodInMonths());
    objTags.setDateOfGrant(prop.getAll().get("tLess")+prop.getAll().get("tDateOfGrant")+prop.getAll().get("tMore")+
            crdetailsObj.getDateOfGrant()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDateOfGrant")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDateOfGrant());
    objTags.setDueTimeFirstContract(prop.getAll().get("tLess")+prop.getAll().get("tDueTimeFirstContract")+prop.getAll().get("tMore")+
            crdetailsObj.getDueTimeFirstContract()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDueTimeFirstContract")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDueTimeFirstContract());
    objTags.setDueTimeLastContract(prop.getAll().get("tLess")+prop.getAll().get("tDueTimeLastContract")+prop.getAll().get("tMore")+
            crdetailsObj.getDueTimeLastContract()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDueTimeLastContract")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDueTimeLastContract());
    objTags.setLastPaymentDate(prop.getAll().get("tLess")+prop.getAll().get("tLastPaymentDate")+prop.getAll().get("tMore")+
            crdetailsObj.getLastPaymentDate()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tLastPaymentDate")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getLastPaymentDate());
    objTags.setMonthlyPaymentAmount(prop.getAll().get("tLess")+prop.getAll().get("tMonthlyPaymentAmount")+prop.getAll().get("tMore")+
            crdetailsObj.getMonthlyPaymentAmount()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tMonthlyPaymentAmount")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getMonthlyPaymentAmount());
    objTags.setDaysMainSumIsOverdue(prop.getAll().get("tLess")+prop.getAll().get("tDaysMainSumIsOverdue")+prop.getAll().get("tMore")+
            ((crdetailsObj.getDaysMainSumIsOverdue()!=null) ? crdetailsObj.getDaysMainSumIsOverdue(): "") +
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDaysMainSumIsOverdue")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDaysMainSumIsOverdue());
    if(crdetailsObj.getDaysInterestIsOverdue()!=null){
    objTags.setDaysInterestIsOverdue(prop.getAll().get("tLess")+prop.getAll().get("tDaysInterestIsOverdue")+prop.getAll().get("tMore")+
            ((crdetailsObj.getDaysInterestIsOverdue()!=null) ? crdetailsObj.getDaysInterestIsOverdue(): "") +
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tDaysInterestIsOverdue")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getDaysInterestIsOverdue());
    }
    objTags.setOiaForRepperiod(prop.getAll().get("tLess")+prop.getAll().get("tOiaForRepperiod")+prop.getAll().get("tMore")+
            crdetailsObj.getOiaForRepperiod()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tOiaForRepperiod")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getOiaForRepperiod());
    objTags.setNumberOfProlongs(prop.getAll().get("tLess")+prop.getAll().get("tNumberOfProlongs")+prop.getAll().get("tMore")+
            crdetailsObj.getNumberOfProlongs()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tNumberOfProlongs")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getNumberOfProlongs());
    if(crdetailsObj.getCreditClassCode()!=null){        
    objTags.setCreditClassCode(prop.getAll().get("tLess")+prop.getAll().get("tCreditClassCode")+prop.getAll().get("tMore")+
            ((crdetailsObj.getCreditClassCode()!=null) ? crdetailsObj.getCreditClassCode(): "") +
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditClassCode")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCreditClassCode());
    }
    objTags.setCreditStatusCode(prop.getAll().get("tLess")+prop.getAll().get("tCreditStatusCode")+prop.getAll().get("tMore")+
            crdetailsObj.getCreditStatusCode()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditStatusCode")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCreditStatusCode());
    if(objColl!=null)
    {         
    objTags.setCollateral(prop.getAll().get("tLess")+prop.getAll().get("tCollateral")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCollateral());
            
    objTags.setCollateralTypeCode(prop.getAll().get("tLess")+prop.getAll().get("tCollateralTypeCode")+prop.getAll().get("tMore")+
            objColl.getCollateralTypeCode()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCollateralTypeCode")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getCollateralTypeCode());
    objTags.setAnyInfoToDisting(prop.getAll().get("tLess")+prop.getAll().get("tAnyInfoToDisting")+prop.getAll().get("tMore")+
            objColl.getAnyInfoToDisting()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tAnyInfoToDisting")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getAnyInfoToDisting());
    objTags.setMarketValue(prop.getAll().get("tLess")+prop.getAll().get("tMarketValue")+prop.getAll().get("tMore")+
            objColl.getMarketValue()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tMarketValue")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getMarketValue());
    objTags.setRegistryNo(prop.getAll().get("tLess")+prop.getAll().get("tRegistryNo")+prop.getAll().get("tMore")+
            objColl.getRegistryNo()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tRegistryNo")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getRegistryNo());
    objTags.setRegistryDate(prop.getAll().get("tLess")+prop.getAll().get("tRegistryDate")+prop.getAll().get("tMore")+
            objColl.getRegistryDate()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tRegistryDate")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getRegistryDate());
    objTags.setRegistryAgency(prop.getAll().get("tLess")+prop.getAll().get("tRegistryAgency")+prop.getAll().get("tMore")+
            objColl.getRegistryAgency()+
            prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tRegistryAgency")+prop.getAll().get("tMore"));
            XMLmassiv.add(objTags.getRegistryAgency());

    objTags.setCollateral(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCollateral")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCollateral());
    }
    objTags.setCredit(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCredit")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCredit());
}
    

    
    Otf.MakeXML(XMLmassiv);

    if(tag_name.contentEquals("Credits"))
    {
        System.out.println("Thrid K Value"+getK());
    System.out.println(" Last "+tag_name.toString());
    XMLmassiv.clear();
    
    if(t==0)
    {
     //XMLmassiv.add("<CONGRATULATIONS> Hec bir səhv tapılmadı </CONGRATULATIONS>");
     XMLmassiv.add(
     prop.getAll().get("tLess")+prop.getAll().get("tCongratulations")+prop.getAll().get("tMore")+
     prop.getAll().get("tNoError")+
     prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCongratulations")+prop.getAll().get("tMore")
     );
    }
    objTags.setCredits(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCredits")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCredits());
    
    objTags.setCreditInfo(prop.getAll().get("tLess")+prop.getAll().get("tSlash")+prop.getAll().get("tCreditInfo")+prop.getAll().get("tMore"));
    XMLmassiv.add(objTags.getCreditInfo());
    
    Otf.MakeXML(XMLmassiv);
    setK(0); t=0; //Counter=0;
    }

    }

    
}
