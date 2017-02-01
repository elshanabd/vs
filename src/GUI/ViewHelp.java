/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.OpenFile.file;
import Parsing.Handler2;
import WriteToFiles.OutputToFile;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.View;

/**
 *
 * @author Elshan_Abdullayev
 */
public  class ViewHelp extends JInternalFrame  {
    
    
        private JPanel northPanel = new JPanel();
    //for creaing the North Label
    private JLabel northLabel = new JLabel("View Help");

    //for creating the Center Panel
    private JPanel centerPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private JPanel informationLabelPanel = new JPanel();

    //for creating an array of JLabel
    private JLabel[] informationLabel = new JLabel[1];
    private JLabel lblShelfNo = new JLabel(" Shelf No");
    private JTextField txtShelfNo = new JTextField();
    //for creating an array of String
    private String[] informationString = {
        " The book subject: "
//            , " The book title: ",
//        " The name of the Author(s): ", " The name of the Publisher: ",
//        " Copyright for the book: ", " The edition number: ", " The number of Pages: ",
//        " ISBN for the book: ", " The number of copies: ", " The name of the Library: "
    };
    //for creating an Internal Panel in the center panel
    private JPanel informationTextFieldPanel = new JPanel();
    //for creating an array of JTextField
    private JTextField[] informationTextField = new JTextField[1];

    //for creating an Internal Panel in the center panel
    private JPanel insertInformationButtonPanel = new JPanel();
    //for creating a button
    private JButton insertInformationButton = new JButton("Open Help File (PDF)");

    //for creating South Panel
    private JPanel southPanel = new JPanel();
    //for creating a button
    private JButton OKButton = new JButton("Exit");

    //create objects from another classes for using them in the ActionListener
    //private Books book;
    //for creating an array of string to store the data
    private String[] data;
    //for setting availble option to true
    private boolean availble = true;
    

    
 public ViewHelp() {
        //for setting the title for the internal frame
        super("Table View", true, true, true, true);
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

        //for setting the layout
        centerPanel.setLayout(new BorderLayout());
        //for setting the border to the panel
        centerPanel.setBorder(BorderFactory.createTitledBorder("Application info"));
        //for setting the layout
//        informationLabelPanel.setLayout(new GridLayout(1, 2, 1, 1));
        /***********************************************************************
         * for adding the strings to the labels, for setting the font 		   *
         * and adding these labels to the panel.							   *
         * finally adding the panel to the container						   *
         ***********************************************************************/
//        for (int i = 0; i < informationLabel.length; i++) {
//            informationLabelPanel.add(informationLabel[i] = new JLabel(informationString[i]));
//            informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
//        }
//        centerPanel.add("West", informationLabelPanel);

        //for setting the layout
        //informationTextFieldPanel.setLayout(new GridLayout(1, 1, 1, 1));
        informationLabelPanel.setLayout(new BoxLayout(informationLabelPanel, View.Y_AXIS));
        
        /***********************************************************************
         * for adding the strings to the labels, for setting the font 		   *
         * and adding these labels to the panel.							   *
         * finally adding the panel to the container						   *
         ***********************************************************************/
//        for (int i = 0; i < informationTextField.length; i++) {
//            informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
//            informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
//        }
        
        
        lblShelfNo.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        //lblShelfNo.setMaximumSize();
        lblShelfNo.setText("<html> <head></head><body>"
                + "<h2>Program təminatı haqqında </h>" +

"<p>Validation System: Program təminatı bankların və BOKTların(Bank olmayan kredit təşkilatlarının) "
                + "istifadəsi üçün nəzərdə tutulmuşdur. <br>"
                + "Program təminatı  aylıq kredit portfelinin öncədən yoxlanılması səhvlərin aşkarlanması və <br>"
                + "aradan qaldırılması üçün faydalı vasitədir. VS bütün ƏS(Əməliyyat Sistemləri) üçün keçərlidir.<br>"
                + "VS işləməsi üçün sadəcə JDK 1.8 öncədən sistemə qurulmalıdır.</p>" +

"<h2>Program təminatı necə işləyir ? </h2>" +

"<p>VS-ə göndərilən hər bir XML uzantılı file program vastəsi ilə emal edilir.<br>" +
"Emailın nəticəsində iki fayıl Excel və XML fayılları əmələ gəlir.<br>"
                + "Excel faylı ilkin XML-in email zamanı səhv aşkarlanmış məlumatlar haqqında hesabatdır.<br> "
                + "XML fayıl isə həmin səhv məlumatlardan ibarət yeni XML uzantılı fayıldır.<br> "
                + "VS- vastəsilə həmin 2-ci XML-i yenidən dəyişdirmək və ya səhvləri aradan qaldırmaq üçün "
                + "istifadə etmək olar.</p>" +

"<h2>Program təminatı nəyi asanlaşdırır?</h2>" +

"<p>Aylıq göndərilən məlumatların Mərkəzləşdirilmiş Kredit Reyestrinə təqdim etməmişdən qabaq VS<br> "
                + "vastəsi ilə yoxlamaqla əvvəlcədən səhvləri aşkarlamaq mümkündür.<br> "
                + "Səhvlər mövcud olan məlumatlar aşkarlandırdıqdan sonra həm daxili sistemdə həm də XML "
                + "faylda aradan qaldırmaq olar.</p>");
        informationLabelPanel.add(lblShelfNo);
//        txtShelfNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
//        informationTextFieldPanel.add(txtShelfNo);
        
        //centerPanel.add("Center", informationTextFieldPanel);
centerPanel.add("Center", informationLabelPanel);
        /***********************************************************************
         * for setting the layout for the panel,setting the font for the button*
         * and adding the button to the panel.								   *
         * finally adding the panel to the container						   *
         ***********************************************************************/
        insertInformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        insertInformationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        insertInformationButtonPanel.add(insertInformationButton);
        centerPanel.add("South", insertInformationButtonPanel);
        cp.add("Center", centerPanel);

        /***********************************************************************
         * for setting the layout for the panel,setting the font for the button*
         * adding the button to the panel & setting the border.				   *
         * finally adding the panel to the container						   *
         ***********************************************************************/
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        OKButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        southPanel.add(OKButton);
        southPanel.setBorder(BorderFactory.createEtchedBorder());
        cp.add("South", southPanel);

        /***********************************************************************
         * for adding the action listener to the button,first the text will be *
         * taken from the JTextField[] and make the connection for database,   *
         * after that update the table in the database with the new value      *
         ***********************************************************************/
        
                insertInformationButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) { 
                                    Thread runner = new Thread() {
                        private OutputToFile otf;

                        public void run() {
                
                              if(!Desktop.isDesktopSupported()){
                            System.out.println("Desktop is not supported");
                            return;
                            }
                           // /Users/esmira_bayramova/Documents/Projects/NewGUI/./ElshanAbdullayev.pdf
                     file = new File("./VS_instruction.pdf");      
                   //file = new File("/Users/esmira_bayramova/Documents/Projects/NewGUI/./ElshanAbdullayev.pdf");
                             Desktop desktop = Desktop.getDesktop();
              if(file.exists()){
                  try {
                   desktop.open(file);
                            } catch (IOException ex) {
                                Logger.getLogger(Handler2.class.getName()).log(Level.SEVERE, null, ex);
                            }     
              }
                      }
                    };
                    runner.start();
            } 
                });
        
  
  OKButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        //for setting the visible to true
        setVisible(true);
        //show the internal frame
        pack();
    
 }
}
