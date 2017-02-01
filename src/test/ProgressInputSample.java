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
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.ProgressMonitorInputStream;

public class ProgressInputSample {
  public static final int NORMAL = 0;

  public static void main(String args[]) throws Exception {
    int returnValue = NORMAL;
    if (args.length != 1) {
      System.err.println("Usage:");
      System.err.println("java ProgressInput filename");
    } else {
      FileInputStream fis = new FileInputStream(args[0]);
      JLabel filenameLabel = new JLabel(args[0], JLabel.RIGHT);
      filenameLabel.setForeground(Color.black);
      Object message[] = { "Reading:", filenameLabel };
      ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(null, message, fis);
      InputStreamReader isr = new InputStreamReader(pmis);
      BufferedReader br = new BufferedReader(isr);
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
        Thread.sleep(500);
      }
      br.close();
    }
    // AWT Thread created - must exit
    System.exit(returnValue);
  }
}

