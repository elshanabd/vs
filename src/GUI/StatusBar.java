package GUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elshan_abdullayev
 */

//import the packages for using the classes in them into the program

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 *A public class
 */

public class StatusBar extends JPanel {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/
	private JLabel statusBar = new JLabel("  ");

	//constructor of StatusBar
	public StatusBar() {
		statusBar.setFont(new Font("Tahoma", Font.BOLD, 9));
		this.add(statusBar);
		this.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
	}
}