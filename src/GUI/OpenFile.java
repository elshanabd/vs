package GUI;



import Parsing.SaxParser;
import java.awt.FlowLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import java.time.Clock;
import java.util.logging.Handler;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */
public class OpenFile extends JInternalFrame{

   String []options1 = {"Ətraflı yoxlamaya davam","Cancel"};
   JPanel myPanel;
    //SAXParser sParser;
    Handler handler;
    //String account_no;
    static File file;
    static File dir;
    SaxParser sp;
    boolean vld;
    ZipEntry entry;
    private static final String DEST_FOLDER = ".//Extract";
    static final int BUFFER = 2048;
    
    OpenFile() throws FileNotFoundException, IOException{
        
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
   
        
    JFileChooser    fc = new JFileChooser();
    if (dir!=null){
        fc.setCurrentDirectory(dir);
    }
    String[] EXTENSION=new String[]{"xml","zip"};
    FileFilter filterXml = new FileNameExtensionFilter("XML fayıllar",EXTENSION[0] );
    FileFilter filterZip = new FileNameExtensionFilter("Zip fayıllar",EXTENSION[1] );
    
    fc.addChoosableFileFilter(filterXml);
    fc.addChoosableFileFilter(filterZip);
    

    int ret = fc.showDialog(null, "Faylı Seç");
//  int ret = fc.showSaveDialog(null);

    
    if (ret == JFileChooser.APPROVE_OPTION) {
      file = fc.getSelectedFile();
      dir=file.getParentFile();
      //File file =fc.showSaveDialog();
       //size=file.length();
     
      
      String filename = file.getName();
      String ext = filename.substring(filename.lastIndexOf(".") + 1, filename.length()).toUpperCase();
      
      String xml="xml".toUpperCase();
      String zip="zip".toUpperCase();
      
      /**Swich begin**/
      
            switch (ext) {
          case "XML": System.out.println();
                    sp= new SaxParser();
          //sp.setXmlfile(file.toString());
          sp.setXmlInput(new FileInputStream(file));
          System.out.println("Selected file : "+file);
          sp.getSaxParser();
          
          vld=sp.isValid();
          if(vld!=false)
          {
//    JOptionPane.showMessageDialog(null, "İlkin yoxlama uğurla başa çatdı", 
//       "Faylın ilkin yoxlama mərhələsi", JOptionPane.INFORMATION_MESSAGE);
//    
//              sp = new SaxParser();
//              sp.setXmlInput(new FileInputStream(file));
//              sp.getSaxParser(vld);

              
              myPanel = new JPanel();
              myPanel.add(new JLabel("İlkin yoxlama uğurla başa çatdı"));
    int res = JOptionPane.showOptionDialog(null, myPanel,"Faylın ilkin yoxlama mərhələsi",
                          JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,options1, null);
    
     switch (res){ 
        case 0: {//JOptionPane.showMessageDialog(null, "Şəxsiyyət Vəsiqəsi Seriya Nömrəsi(AZE) üzrə Sorğulama üçün faylın daxil edilməsi");
              sp = new SaxParser();
              sp.setXmlInput(new FileInputStream(file));
              sp.getSaxParser(vld);
             
        break;}
        case 1: {JOptionPane.showMessageDialog(null, "Yoxlama sonlandırıldı");
            
        break;}
            default: System.out.println("NoSelected");
        break;
        }  

          

          }

          
          
          break;
          case "ZIP": 
              System.out.println(" Zip Part : begin");
              File folder = new File(DEST_FOLDER);
              if(!folder.exists()){
                  folder.mkdir();
              }
             BufferedOutputStream dest = null;
                        sp= new SaxParser();
          //sp.setXmlfile(file.toString());
          FileInputStream fis = new FileInputStream(file);
          ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
          while((entry = zis.getNextEntry()) != null) {
          //entry =zis.getNextEntry();
          int count;
                          byte data[] = new byte[BUFFER];
          System.out.println(" entry Zip: "+entry.getName());
          File newFile = new File(DEST_FOLDER + File.separator + entry.getName());
                          if(entry.isDirectory()){
                    if(!newFile.exists()){
                        newFile.mkdirs();
                                  System.out.println(" Output of Zip is Directory");

                    }
                }
          else{
                              
                FileOutputStream fos = new FileOutputStream(newFile);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                   dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();               

              String destPath = DEST_FOLDER + File.separator + entry.getName();
              File fileNew=new File(destPath);
              sp.setXmlInput(new FileInputStream(fileNew));
          //System.out.println("Selected file : "+destPath);
          sp.getSaxParser();
          
          vld=sp.isValid();
          if(vld!=false)
          {


              myPanel = new JPanel();
              myPanel.add(new JLabel("İlkin yoxlama uğurla başa çatdı"));
    int res = JOptionPane.showOptionDialog(null, myPanel,"Faylın ilkin yoxlama mərhələsi",
                          JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,options1, null);
    
     switch (res){ 
        case 0: {//JOptionPane.showMessageDialog(null, "Şəxsiyyət Vəsiqəsi Seriya Nömrəsi(AZE) üzrə Sorğulama üçün faylın daxil edilməsi");
              sp = new SaxParser();
              sp.setXmlInput(new FileInputStream(fileNew));
              sp.getSaxParser(vld);
             
        break;}
        case 1: {JOptionPane.showMessageDialog(null, "Yoxlama sonlandırıldı");
            
        break;}
            default: System.out.println("NoSelected");
        break;
        }  
 
          }
          }
          }
            zis.closeEntry();
            zis.close();
            fis.close();
          break;
          default :  
    JOptionPane.showMessageDialog(null, "Düzgün fayl daxil edilməmişdir : Faylın uzantısı ["+ext+"] ", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
    
              
                  
      }
      
      /**Swich end**/
      
      

    } 
//    else 
//    {
//        JOptionPane.showMessageDialog(null, "Fayıl seçilməmişdir", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
//    }
        
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
