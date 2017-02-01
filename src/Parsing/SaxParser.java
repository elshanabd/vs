package Parsing;




import Properties.data.rules.ConfigProperties;
import java.io.FileInputStream;
import java.io.InputStream;

//import javax.xml.XMLConstants;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Validator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//import javax.xml.transform.stream.StreamSource;
//import javax.xml.validation.Schema;
//import javax.xml.validation.SchemaFactory;
//import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 * 
 */




public class SaxParser {
    
    
    //String xmlfile;
   SAXParser  saxParser;
   static InputStream    xmlInput;
   static InputStream    xsdInput;
   Handler2 handler;
   Handler hander_new;
   ShemaValidation  sv;
   public  boolean valid;
   //private Handler handler_new;

    public boolean isValid() {
        return valid;
    }

 

    public  void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public void setXmlInput(InputStream xmlInput) {
        this.xmlInput = xmlInput;
    }
    
    public static InputStream getXmlInput() {
        return xmlInput;
    }
    
//    public String getXmlfile() {
//        return xmlfile;
//    }
//
//    public void setXmlfile(String xmlfile) {
//        this.xmlfile = xmlfile;
//    }
    
    
    public void getSaxParser()
    {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                handler   = new Handler2();
                
//                System.out.println(" Method : ["+xmlfile+"]");
try {

    
    if(xmlInput!=null){
        
        System.out.println("getSaxParser invoked");
        //xsdInput  = new FileInputStream("src/XSD/credits.xsd");
        xsdInput= ConfigProperties.class.getResourceAsStream("/XSD/credits.xsd");
    
    //InputStream    xmlInput= new FileInputStream(xmlfile);
    
  //D://desk//Unibank//aprel//CRED_REG_PRINT.xml
    
    //InputStream    xmlInput  = new FileInputStream("D:\\xml_files\\Unibank\\CRED_REG_PRINT.xml");
    //InputStream    xmlInput  = new FileInputStream("D:\\xml_files\\Accessbank_1245_03_09_2013\\Accessbank_1245_03_09_2013.xml");
    
      

    //RuleSet rs=new RuleSet();
    //GeneralRulesCheckup grc= new GeneralRulesCheckup();
    //Credit view= new Credit();
    
            // saxParser = factory.newSAXParser();
             
             //saxParser.parse(xmlInput, handler);
    
    
   /*For XSD validation Part*/
   /*************************/
   /*************************/
   /*************************/
//   boolean valid=sv.validateXMLSchema(xsdInput,xmlInput);
//    if (valid==true){
//        System.out.println("Valid true");
//        if(xmlInput!=null){
//            saxParser = factory.newSAXParser();
//             xmlInput = getXmlInput();
//             saxParser.parse(xmlInput, handler);
//            
//   
//        } else {System.out.println("");}
//    }else {
//        System.out.println("Valid false");
//        
//    }
    valid=sv.validateXMLSchema(xsdInput,xmlInput); 
    
    if(valid!=false)
    {
        setValid(valid);
    }
   
//handler.getHeaderInfo();

 
 /* Kreditlerin ve  Zaminlerin sayi*/  
 System.out.println(handler.CountCredits());

    

    }
    
} catch (Throwable err) {
    err.printStackTrace ();
}
    }
    
    
    public SaxParser()
    {
 System.out.println("Call construcot");
        
    }

    public void getSaxParser(boolean valid)
    {
                SAXParserFactory factory = SAXParserFactory.newInstance();
           Handler2  handler_new   = new Handler2();
                
//                System.out.println(" Method : ["+xmlfile+"]");
try {

    
    if(xmlInput!=null){
        
        System.out.println("getSaxParser invoked account");

             saxParser = factory.newSAXParser();
             
             saxParser.parse(xmlInput, handler_new);
  
//handler.getHeaderInfo();

 /* Kreditlerin ve  Zaminlerin sayi*/  
 //System.out.println(handler.CountCredits());
    }
    
} catch (Throwable err) {
    err.printStackTrace ();
}
    }
    
    
    
 
}
