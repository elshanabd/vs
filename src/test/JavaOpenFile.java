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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class JavaOpenFile {

    public static void main(String[] args) throws IOException {
        //text file, should be opening in default text editor
        File file = new File("D:\\developing\\NetBeans_Projects\\NewGUI\\1119Azərnəqliyyatbank ASC_1476684684398.txt");
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
        //let's try to open PDF file
        file = new File("D:\\developing\\NetBeans_Projects\\NewGUI\\1119Azərnəqliyyatbank ASC_1476684684398.xlsx");
        if(file.exists()) desktop.open(file);
    }

}