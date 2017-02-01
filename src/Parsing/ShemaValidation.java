/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parsing;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


/**
 *
 * @author elshan
 */
public class ShemaValidation {

    
            public static boolean validateXMLSchema(InputStream xsdPath, InputStream xmlPath) throws JAXBException{
         
        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdPath));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new Parsing.XsdErrorHandler() {});
            
            validator.validate(new StreamSource(xmlPath));
            
            System.out.println("Validation is successful");
            
            
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage() );
            JOptionPane.showMessageDialog(null, "İlkin yoxlama xətası"
                    +e.getMessage()
                    , " Fayılın ilkin yoxlama mərhələsi", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        return true;
    }
    
}
