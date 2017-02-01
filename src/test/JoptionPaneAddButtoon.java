/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JOptionPane;

/**
 *
 * @author elshan.abdullayev
 */
public class JoptionPaneAddButtoon {
 
      public static void main(String[] argv) throws Exception {

    String[] buttons = { "Yes", "Yes to all", "No", "Cancel" };

    int rc = JOptionPane.showOptionDialog(null, "Bir", "Abc",
        JOptionPane.PLAIN_MESSAGE , 0, null, buttons, buttons[2]);

    System.out.println(rc);

  }
}
