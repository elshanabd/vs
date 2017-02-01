/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author elshan_abdullayev
 */
//import the packages for using the classes in them into the program

import WriteToFiles.OutputToFile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *A public class
 */
public class MakeTable extends JInternalFrame {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/
static String PanelName="MakeView";
	//for creating the North Panel
	private JPanel northPanel = new JPanel();
	//for creaing the North Label
	private JLabel northLabel = new JLabel("Results Of Processing");

	//for creating the Center Panel
	private JPanel centerPanel = new JPanel();
	//for creating an Internal Panel in the center panel
	private JPanel informationLabelPanel = new JPanel();
	//for creating an array of JLabel
	private JLabel[] informationLabel = new JLabel[7];
	//for creating an array of String
	private String[] informaionString = {" Member ID: ", " The Password: ", " Rewrite the password: ",
	                                     " The Name: ", " E-MAIL: ", " Major Branch:", " Expired: "};
	//for creating an Internal Panel in the center panel
	private JPanel informationTextFieldPanel = new JPanel();
	//for creating an array of JTextField
	private JTextField[] informationTextField = new JTextField[7];
	//for creating an array of JPasswordField
	private JPasswordField[] informationPasswordField = new JPasswordField[2];

	//for creating an Internal Panel in the center panel
	private JPanel insertInformationButtonPanel = new JPanel();
	//for creating a button
	private JButton insertInformationButton = new JButton("Insert the Information");

	//for creating the South Panel
	private JPanel southPanel = new JPanel();
	//for creating a button
	private JButton OKButton = new JButton("Exit");
        private JButton SaveButton= new JButton("Save Changes");
        private JButton SearchButton = new JButton("Search");
        private JTextArea textArea=new JTextArea(5,50);
        private JTextField searchField= new JTextField(25);
        private Highlighter hili;
        private Pattern p;

        int offset;
        int length;
        File datainFile;
        InputStream fis;
        BufferedReader reader ;

	//create objects from another classes for using them in the ActionListener
	//private Members member;
	//for creating an array of string to store the data
	//private String[] data;


	//constructor of addMembers
	public MakeTable() {
		//for setting the title for the internal frame
		super(PanelName, true, true, true, true);
		//for setting the icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Add16.gif")));
		//for getting the graphical user interface components display area
		Container cp = getContentPane();

		//for setting the layout
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//for setting the font
		northLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		//for adding the label to the panel
		northPanel.add(northLabel);
		//for adding the panel to the container
		cp.add("North", northPanel);

		//for setting the layout
		centerPanel.setLayout(new BorderLayout());
		//for setting the border to the panel
		centerPanel.setBorder(BorderFactory.createTitledBorder("Wrong Data  :"));
		//for setting the layout
		informationLabelPanel.setLayout(new GridLayout(1, 2, 1, 1));
		//for setting the layout
		informationTextFieldPanel.setLayout(new GridLayout(1, 2, 1, 1));
		/***********************************************************************
		 * for adding the strings to the labels, for setting the font		   *
		 * and adding these labels to the panel.							   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
//		for (int i = 0; i < informationLabel.length; i++) {
//			informationLabelPanel.add(informationLabel[i] = new JLabel(informaionString[i]));
//			informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
//		}
                
//informationLabelPanel.add(informationLabel[0] = new JLabel(informaionString[0]));
//for adding the panel to the centerPanel
//		centerPanel.add("West", informationLabelPanel);

		/***********************************************************************
		 * for adding the JTextField and JPasswordField to the panel and       *
		 * setting the font to the JTextField and JPasswordField. Finally      *
		 * adding the panel to the centerPanel                                 *
		 ***********************************************************************/
//		for (int i = 0; i < informationLabel.length; i++) {
//
//			
//				informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
//				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
//			
//		}

                JScrollPane scrollPane = new JScrollPane(textArea);
                informationTextFieldPanel.add(scrollPane);    
		centerPanel.add("Center", informationTextFieldPanel);
                
		/***********************************************************************
		 * for setting the layout for the panel,setting the font for the button*
		 * and adding the button to the panel.								   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		insertInformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		insertInformationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		insertInformationButtonPanel.add(insertInformationButton);
                                insertInformationButtonPanel.add(SearchButton);
                                insertInformationButtonPanel.add(searchField);
                insertInformationButtonPanel.add(SaveButton);
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
				//for checking if there is a missing information
					Thread runner = new Thread() {
                                            //private OpenFile opf;
                                            private OutputToFile otf;

							public void run() {
                                                            
        otf = new OutputToFile();
        if(!otf.takeFilePath().trim().contentEquals("")){
        System.out.println(" Show File Path : "+otf.takeFilePath()+" >>>>");
        centerPanel.setBorder(BorderFactory.createTitledBorder("Wrong Data  :"+otf.takeFilePath()));
        textArea.setText("");
        datainFile=new File(otf.takeFilePath());
                                                            

                                                                try {
                                                                    fis = new FileInputStream(datainFile);
                                                                    reader = new BufferedReader(new InputStreamReader(fis));
                                                                    //StringBuilder out = new StringBuilder();
                                                                    String line;
                                                                    while ((line = reader.readLine()) != null) {
                                                                        //out.append(line);
                                                                        
                                                                        //textArea.setText(line+System.getProperty( "line.separator"));
                                                                        textArea.append(line+System.getProperty( "line.separator"));
                                                                        
                                                                            }
                                                                    //System.out.println(out.toString());   //Prints the string content read from input stream
                                                                    reader.close();
                                                                    
   

                
                                                                    
                                                                    
                                                                } catch (FileNotFoundException ex) {
                                                                    Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                                                } catch (IOException ex) {
                                                                    Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                                
                                                                
                                                                
                                                                }else 
                                                                {
                                                                    JOptionPane.showMessageDialog(null, "Əvvəlcədən [XML] uzantılı fayıl emal edilməlidir", "Xəbərdarlıq", JOptionPane.WARNING_MESSAGE);
                                                                }
System.out.println(" Button clicked");

							}
						};
						runner.start();
					
					//JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		//for adding the action listener for the button to dispose the frame
                
                
                SearchButton.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent ae) {
                    
                    				Thread runner;
                    runner = new Thread() {  
                        
                        public void run() {
                            
                            
                            
                            hili=  textArea.getHighlighter();
                            Highlighter.Highlight[] hilis = hili.getHighlights();
                            for(int i=0 ; i<hilis.length; i++)
                            {
                                if (hilis[i].getPainter() instanceof Highlighter.HighlightPainter)
                                {
                                    hili.removeHighlight(hilis[i]);
                                }
                            }
                            
                            
                            System.out.println(" Searchable text "+searchField.getText());
                            
                            
Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.cyan );

offset= textArea.getText().indexOf(searchField.getText());
length = searchField.getText().length();

while ( offset != -1)
{
    try
    {
        System.out.println(" Offest1 : "+offset+" Length :"+length);
        
        textArea.getHighlighter().addHighlight(offset, offset + length, painter);
        //offset = textArea.getText().indexOf(searchField.getText(), offset+1);
        
        
        
                              Rectangle viewRect = textArea.modelToView(offset);
                                // Scroll to make the rectangle visible
                                textArea.scrollRectToVisible(viewRect);
System.out.println(" Offest2 : "+offset); offset=-1;
break;

//if(offset==-1)
//{ break;}
        
        
    }
    catch(BadLocationException ble) { System.out.println(ble); }
}



                        }
                    };
						runner.start();
					
                                
			}
                
                });
                
         
                
                
                
                
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println(" Save ");
                                
                                System.out.println(" Out put File Again"+textArea.getText()+" Line Count "+textArea.getLineCount());
                            OutputToFile otf = new OutputToFile();
                                
                                    try {
//                                        textArea.getLineStartOffset(r);
//                                        System.out.println(
//                                                " Line Out :  Start :"+textArea.getLineStartOffset(r)+
//                                                " .... End :"+textArea.getLineEndOffset(r)+
//                                                " data "+textArea.getText().substring(textArea.getLineStartOffset(r), textArea.getLineEndOffset(r)));
    FileOutputStream outputStream = new FileOutputStream(otf.takeFilePath(),false);
    OutputStreamWriter writer = new OutputStreamWriter(outputStream);
for (int r=0;r<textArea.getLineCount();r++){
writer.write(textArea.getText().substring(textArea.getLineStartOffset(r), textArea.getLineEndOffset(r)));
}
writer.flush();
      
writer.close();
                                        
                                    } catch (BadLocationException ex) {
                                        Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                            
           
                                
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