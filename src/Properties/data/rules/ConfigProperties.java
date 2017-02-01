
package Properties.data.rules;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author elshan.abdullayev
 */
public class ConfigProperties {


        private static String path="/resc/resources/settings.properties";  

        
	
	public static HashMap<String,String> getAll(){
		
		Properties prop = new Properties();
                
        HashMap<String,String> map=new HashMap<>();
	    try {

	        
                InputStream input = ConfigProperties.class.getResourceAsStream(path); 
                //System.out.println("Absolute Path Properties "+path);

                
                prop.load(input);
	        input.close();

	        for (final String name: prop.stringPropertyNames()){
	        	map.put(name, prop.getProperty(name));
	        }     
     

	        
	    } catch (IOException io) {
	        io.printStackTrace();
	        throw new RuntimeException(io);
	    }	
		return map;
	}
    
}


