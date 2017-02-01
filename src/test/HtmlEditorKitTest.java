/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * A complete Java class that demonstrates how to create an HTML viewer with styles,
 * using the JEditorPane, HTMLEditorKit, StyleSheet, and JFrame.
 * 
 * @author alvin alexander, devdaily.com.
 *
 */
public class HtmlEditorKitTest
{
  public static void main(String[] args)
  {
    new HtmlEditorKitTest();
  }
  
  public HtmlEditorKitTest()
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
          

        JFrame j = new JFrame("Html Test");
        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        
        sb.append("<html><h1>    My First Heading    </h1>");
        
        pane.setText(sb+"   <p>My first paragraph.</p>    </body></html>");
        
        
                
                j.add(pane);
                j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                j.setSize(new Dimension(300,200));
                j.setVisible(true);
                
                
      }
    });
  }
}