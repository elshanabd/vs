/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author elshan_abdullayev
 */
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ProgressSample {
  public static void main(String args[]) throws InterruptedException {
      
    JFrame f = new JFrame("JProgressBar Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    final JProgressBar progressBar = new JProgressBar();
    //progressBar.setValue(55);
    
    //for (int i=0; i<=100; i++){
    int g=0;
    String aa="CreditInfo";
    while (aa.contentEquals("CreditInfo")){
        
        
        g++; System.out.println("G :"+g);
        
    final int p=g;
    if (g==100) break;
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Reading...");
    progressBar.setBorder(border);
    content.add(progressBar, BorderLayout.NORTH);
    
    SwingUtilities.invokeLater(new Runnable() {
             public void run() {
               progressBar.setValue(p);
               
             }
         });
         java.lang.Thread.sleep(100);
      f.setSize(300, 100);
      
    f.setVisible(true);
    }
    f.dispose();
  
  }
}