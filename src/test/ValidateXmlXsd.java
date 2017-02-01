/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author elshan.abdullayev
 */
import java.io.FileInputStream;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import static test.ValidateXmlXsd.xsdInput;

/**
  * custom error handler while validating xml against xsd
  */
public class ValidateXmlXsd {
    
    public static InputStream xsdInput;
    public static InputStream    xmlInput;
    public static String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<course id=\"1-ID\">\n" +
            "    <name>JAX-B</name>\n" +
            "    <description>Validate XML against XSD Schema</description>\n" +
            "</course>";
    
     

    public static void main(String... args) {
        try {
            
            xsdInput  = new FileInputStream("src/XSD/CCreditInfo2.xsd");
            //xmlInput  = new FileInputStream("D:\\For_Parsing\\New_pars\\First_Check.xml");
            xmlInput  = new FileInputStream("D:\\For_Parsing\\New_pars\\070616.xml");
            //System.out.println("Custom Error Handler while Validating XML against XSD");
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //Schema schema = factory.newSchema(ValidateXmlXsd.class.getResource("schema.xsd"));
            Schema schema = factory.newSchema(new StreamSource(xsdInput));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new XsdErrorHandler() {});
            
            //validator.validate(new StreamSource(new StringReader(xml)));
            validator.validate(new StreamSource(xmlInput));
            
            System.out.println("Validation is successful");
        } catch (IOException e) {
            // handle exception while reading source
        } catch (SAXException e) {
            //System.out.println("Custom Error Handler while Validating XML against XSD");
            System.out.println("Message: " + e.getMessage());
        }
    }
}