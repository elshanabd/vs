/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author elshan.abdullayev
 */
public class AboutUs extends JInternalFrame{
    
    private JPanel northPanel = new JPanel();
    //for creaing the North Label
    private JLabel northLabel = new JLabel("About Product");

    //for creating the Center Panel
    private JPanel centerPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private JPanel informationLabelPanel = new JPanel();
    
    public AboutUs(){
                //for setting the title for the internal frame
        super("About Validation System", true, true, true, true);
        //for setting the icon
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Add16.gif")));
        //for getting the graphical user interface components display area
        Container cp = getContentPane();

        //for setting the layout
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //for setting the font for the North Panel
        northLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        //for adding the label in the North Panel
        northPanel.add(northLabel);
        //for adding the north panel to the container
        cp.add("North", northPanel);
        informationLabelPanel.setLayout(new GridLayout(4, 1, 1, 1));
        //informationLabelPanel.add(new JLabel("               About Product"));
        informationLabelPanel.add(new JLabel("              Version 3.0 (64 bit)"));
        informationLabelPanel.add(new JLabel("            Mobil : +994 55 2077033"));
        informationLabelPanel.add(new JLabel("         Email : Elshan.abd@gmail.com"));
        informationLabelPanel.add(new JLabel("Copywrite (c) 2015-2019 , Validation System"));
        
        centerPanel.add(informationLabelPanel);
        
        cp.add("Center",centerPanel);
        
        
        
        
        //for setting the visible to true
        setVisible(true);
        //show the internal frame
        pack();
        
    }
    
}
