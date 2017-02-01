package GUI;



import Parsing.SaxParser;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
//import java.time.Clock;
import java.util.logging.Handler;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */
public class OpenFile extends JInternalFrame{

   
    //SAXParser sParser;
    Handler handler;
    //String account_no;
   static File file;
    SaxParser sp;
    
    OpenFile() throws FileNotFoundException{
        
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
   
        
    JFileChooser    fc = new JFileChooser();
                               
    String[] EXTENSION=new String[]{"xml"};
    FileFilter filter = new FileNameExtensionFilter("XML fayıllar",EXTENSION );
    fc.addChoosableFileFilter(filter);

    int ret = fc.showDialog(null, "Faylı Seç");
//  int ret = fc.showSaveDialog(null);

    
    if (ret == JFileChooser.APPROVE_OPTION) {
      file = fc.getSelectedFile();
      //File file =fc.showSaveDialog();
       //size=file.length();
     
      
      String filename = file.getName();
      String ext = filename.substring(filename.lastIndexOf(".") + 1, filename.length()).toUpperCase();
      
      String xml="xml".toUpperCase();
      if(!xml.equals(ext))
      {
          JOptionPane.showMessageDialog(null, "Düzgün fayl daxil edilməmişdir : Faylın uzantısı ["+ext+"] ", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
      } 
      else 
      {
          System.out.println("Seçilən faylın Ölçü:" + file.length());
         
          
           sp= new SaxParser();
           
          
          //sp.setXmlfile(file.toString());
          
           sp.setXmlInput(new FileInputStream(file));
           
           
         // sp.saxParser.parse(file, handler);
        //  sp.saxParser.
          System.out.println("Selected file : "+file);
          sp.getSaxParser();
          
          boolean vld=sp.isValid();
          if(vld!=false)
          {
    JOptionPane.showMessageDialog(null, "İlkin yoxlama uğurla başa çatdı", 
       "Faylın ilkin yoxlama mərhələsi", JOptionPane.INFORMATION_MESSAGE);
    
              sp = new SaxParser();
              sp.setXmlInput(new FileInputStream(file));
              sp.getSaxParser(vld);

          }
//          else 
//          {
//              JOptionPane.showMessageDialog(null, "Fayıl İlkin yoxlamadan keçmədi", "İlkin yoxlama xətası", JOptionPane.ERROR_MESSAGE);
//          }
//          
          
          
      }
    } 
    else 
    {
        JOptionPane.showMessageDialog(null, "Fayıl seçilməmişdir", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
    }
        
    }
    
//         public void actionPerformed(ActionEvent ae) {
//             
//         ae.getSource().equals(ae);
//         }

    
   OpenFile(String account_no) throws FileNotFoundException
            {
                
                
                if(file!=null){
                    System.out.println(" Parametrizied " + account_no+ " File : "+file.getName());
                try {
                sp= new SaxParser();
                sp.setXmlInput(new FileInputStream(file));
                System.out.println("Selected file Table  : "+file);
                sp.getSaxParser();
                    }catch (NullPointerException io) 
                    {
                        io.printStackTrace();
                    }
                    
                } else 
                {
                    System.out.println("File is null ");
                    
                    JOptionPane.showMessageDialog(null, "Əvvəlcədən fayl emalı qeydə alınmamışdır", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
                }
                
                
                
                
            }

}
