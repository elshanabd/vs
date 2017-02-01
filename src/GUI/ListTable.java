
package GUI;

/**
 *
 * @author elshan_abdullayev
 */
//import the packages for using the classes in them into the program

import WriteToFiles.OutputToFile;
import com.sun.java.swing.plaf.motif.MotifComboBoxUI;
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
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.View;

/**
 *A public class
 */
public class ListTable extends JInternalFrame {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the North Panel
    private JPanel northPanel = new JPanel();
    //for creaing the North Label
    private JLabel northLabel = new JLabel("Credit Info Table");

    //for creating the Center Panel
    private JPanel centerPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private JPanel informationLabelPanel = new JPanel();

    //for creating an array of JLabel
    private JLabel[] informationLabel = new JLabel[1];
    private JLabel lblShelfNo = new JLabel(" Shelf No");
    private JTextField txtShelfNo = new JTextField();
    //for creating an array of String

    //for creating an Internal Panel in the center panel
    private JPanel informationTextFieldPanel = new JPanel();
    //for creating an array of JTextField
    private JTextField[] informationTextField = new JTextField[1];

    //for creating an Internal Panel in the center panel
    private JPanel insertInformationButtonPanel = new JPanel();
    //for creating a button
    private JButton insertInformationButton = new JButton("Insert the Information");

    //for creating South Panel
    private JPanel southPanel = new JPanel();
    //for creating a button
    private JButton OKButton = new JButton("Exit");
    
    private JButton SaveButton= new JButton("Save Changes");

    //create objects from another classes for using them in the ActionListener
    //private Books book;
    //for creating an array of string to store the data
    private String data;
    //for setting availble option to true
    private boolean availble = true;

  
    


    public ListTable() {
        
        
        
        //for setting the title for the internal frame
        super("Table View", true, true, true, true);

/******************************************************************/        
/******************************************************************/
/********Begin Input panel for Choosing Account_no from File*******/
/******************************************************************/
/******************************************************************/

//                        String sorgu_ids = JOptionPane.showInputDialog( "Hesab nomresini daxil edin");
//                
//                
//                System.out.println("Account_no : "+sorgu_ids);
//                System.out.println("");
//                  
//                
//                     if(sorgu_ids==null||sorgu_ids.isEmpty())
//                {
//                  System.out.println(" Entered Account_no : "+sorgu_ids);
//        
//                }
//                else
//                {
                
                    
                    
//        System.out.println("No Entered.... ");
//    JButton    btnAdd = new JButton("Add new JTextField!");
//        btnAdd.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//
//                
//                vBox.add(new JLabel("<id>"));
//                
//                JTextField tf= new JTextField(20);
//                tf.setText("AAA");
//                vBox.add(tf);
//                vBox.add(new JLabel("</id>"));
//
//                pack();
//            }
//
//        });
//        
//                vBox = Box.createVerticalBox();
//        centerPanel = new JPanel();
//        
//        JPanel contentPanel = (JPanel) getContentPane();
//        contentPanel.setLayout(new BorderLayout());
//        contentPanel.add(btnAdd, "South");
//        contentPanel.add(centerPanel, "Center");
//
//        
//        
//        centerPanel.add(vBox);
//        pack();
                    
                    
//                }

/******************************************************************/        
/******************************************************************/
/********End Input panel for Choosing Account_no from File*********/
/******************************************************************/
/******************************************************************/

                     
        
        //for setting the icon
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Add16.gif")));
        //for getting the graphical user interface components display area
        Container cp = getContentPane();
        //GridBagConstraints c = new GridBagConstraints();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setBounds(50, 30, 300, 50);

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
        centerPanel.setBorder(BorderFactory.createTitledBorder("Wrong data"));

  
        
        //informationLabelPanel.add(scrollPane);
        //informationTextFieldPanel.add(scrollPane);
        //informationTextFieldPanel.setLayout(new GridLayout(30, 1, 1, 1));
        informationLabelPanel.setLayout(new BoxLayout(informationLabelPanel, View.Y_AXIS));
        //informationLabelPanel.setLayout((LayoutManager) new JScrollPane());
        
                   // JScrollPane s = new JScrollPane(informationLabelPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //informationLabelPanel.add(new JScrollBar());
        //informationLabelPanel.setLayout(new GridLayout(10, 1, 1, 1));
        //informationTextFieldPanel.add(new JLabel("abcce"));
        //informationTextFieldPanel.add(new JTextField(20));
        
        
        
        //centerPanel.add(s);
        //centerPanel.add(informationTextFieldPanel);

        //scrollPane.add(centerPanel);

        
        //cp.add("Center",scrollPane);
        cp.add("Center", centerPanel);
        

        insertInformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        insertInformationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        SaveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        insertInformationButtonPanel.add(insertInformationButton);
        insertInformationButtonPanel.add(SaveButton);
        
        southPanel.add("South", insertInformationButtonPanel);
        



        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        OKButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        southPanel.add(OKButton);
        //southPanel.setBorder(BorderFactory.createEtchedBorder());
        
        cp.add("South", southPanel);

        insertInformationButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
//informationLabelPanel.removeAll();
                //for checking if there is a missing information
                //if (isCorrect()) {
                    Thread runner = new Thread() {
                        private OutputToFile otf;

                        public void run() {
                            

                         //informationLabelPanel.removeAll();


        otf = new OutputToFile();
        if(!otf.takeFilePath().trim().contentEquals("")){
        System.out.println(" Show File Path : "+otf.takeFilePath()+" >>>>");
        centerPanel.setBorder(BorderFactory.createTitledBorder("Wrong Data  :"+otf.takeFilePath()));
        //textArea.setText("");
            File datainFile = new File(otf.takeFilePath());
                                                            

                                                                try {
            InputStream fis = new FileInputStream(datainFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                                                                    //StringBuilder out = new StringBuilder();
                String line;
                String [] splitting;
                String open;
                String close;
                //vBox = Box.createVerticalBox();
            while ((line = reader.readLine()) != null) {
                
                //System.out.println("Index of slash : "+line.indexOf("</")+" and index of > "+line.indexOf(">")+" in  this line : "+line);
                
                if(line.indexOf("</")>0)
                {
                    //line.substring(line.indexOf(">"), line.indexOf("</"))
                    
/*********Open Scripts begin *******************/                    
                    splitting=line.split(line.substring(line.indexOf(">")+1, line.indexOf("</")), 2);
                    open =splitting[0].replace("<","");
                    open=open.replace(">", " ");
                    close=splitting[1].replace("</", " ");
                    close=close.replace(">", "");
//                    
                    if(line.substring(line.indexOf(">"), line.indexOf("</")).length()==1)
                    {
                    open=line.substring(1, line.indexOf("></"));
                    close=line.substring(line.indexOf("></")+3).replace(">", "");
                    }
/*********Open Scripts end *******************/                    
                    
                    
                    //System.out.println("Divider ["+line.substring(line.indexOf(">")+1, line.indexOf("</")) +"] Splitting vars :"+splitting[0]+" and "+splitting[1]);
                    //str.append("<tr><td border=1><input type='text' size=40 name=tags value='"+line+"'> </td></tr>");

/************Main Part begin******************/          
//                            str.append("<tr><td><pre><code>"+
//                            open+"</code></pre></td><td border=0><input type='text' size=40 name=tags value='"+
//                            line.substring(line.indexOf(">")+1, line.indexOf("</"))+"'></td><td><pre><code>"+
//                            close+"</code></pre></td>");

 JPanel combine = new JPanel();
         
 JTextField tf= new JTextField(30);
                            tf.setText(line.substring(line.indexOf(">")+1, line.indexOf("</")));
         combine.add(new JLabel("<".concat(open.trim().concat(">"))));
         combine.add(tf);
         combine.add(new JLabel("</".concat(close.trim().concat(">"))));
         
         informationLabelPanel.add(combine);
//                            informationLabelPanel.add(new JLabel("<".concat(open.concat(">"))));
//                            informationLabelPanel.add(tf);
//                            informationLabelPanel.add(new JLabel("</".concat(close.concat(">"))));
                            
                           // centerPanel.add(new JLabel(open));
                            
/************Main Part end********************/                    

//                    str.append("<div>"+
//                            open+"<input type='text' size=40 name=tags value='"+
//                            line.substring(line.indexOf(">")+1, line.indexOf("</"))+"'>"+
//                            close+"</div>");
                    
                }
                else
                {
                 //   str.append("<div>"+ line.toString() +"</div>");

/*********Close Tag begin********/                    
                     //line=line.replace("<", "").replace("/", "").replace(">","");
//                    ////close=line.substring(line.indexOf("></")+3).replace(">", "");
//                 str.append("<tr><td><pre><code>"+
//                            line+"</code></pre></td>"
//                 );

informationLabelPanel.add(new JLabel(line));
/*********Close Tag end*********************/   
                    //System.out.println(" other tags "+line.toString());
                    
                }
            
            }
    //pane.setText(str.toString()+"</table>");

    
            //centerPanel.add(informationTextFieldPanel);
            //vBox.add(informationLabelPanel);
            
            JScrollPane s = new JScrollPane(informationLabelPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            centerPanel.add(s);
            //scrollPane.add(centerPanel);
            
            //centerPanel.add("Center",informationTextFieldPanel);
            //centerPanel.add(scrollPane.add(informationTextFieldPanel));
            //centerPanel.add("East",informationLabelPanel);
//cp.add("center",scrollPane);
   
                                                                        
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
                //} //if there is a missing data, then display Message Dialog
                //else {
                    //JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
                //}
            }
        });
        
        
        
        		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println(" Save ");
                                
    // System.out.println(" Out put File Again"+informationLabelPanel.getComponents() +" Componenet Count "+informationLabelPanel.getComponentCount());
     

Component[] components = informationLabelPanel.getComponents(); 
//System.out.println(" Say  "+components.length);

Component component = null; 
//for (int i = 0; i < components.length; i++){ 
//component = components[i]; 
//
//if (component instanceof JLabel) 
//{ 
//
//System.out.println("Out : "+((JLabel) component).getText());
//} else if (component instanceof JPanel)
//{
//    Component[] SubComponents = ((JPanel) component).getComponents();
//    //System.out.println(" Sub Size :"+SubComponents.length);
//    Component SubComponent = null;
//    for (int t = 0; t < SubComponents.length; t++) 
//{ 
//SubComponent = SubComponents[t]; 
//
//    if (SubComponent instanceof JTextField) 
//        {
//            System.out.println("Out_else textField  : "+((JTextField) SubComponent).getText());
//        } else if (SubComponent instanceof JLabel)
//        {
//            System.out.println("Out_else LableText  : "+((JLabel) SubComponent).getText());
//        }
//    
//}
//    
//    //System.out.println("Out_else : "+component.getName());
//}
//}
       
    
            OutputToFile otf = new OutputToFile();
                                
                                    try {
//                                        textArea.getLineStartOffset(r);
//                                        System.out.println(
//                                                " Line Out :  Start :"+textArea.getLineStartOffset(r)+
//                                                " .... End :"+textArea.getLineEndOffset(r)+
//                                                " data "+textArea.getText().substring(textArea.getLineStartOffset(r), textArea.getLineEndOffset(r)));
    FileOutputStream outputStream = new FileOutputStream(otf.takeFilePath(),false);
    OutputStreamWriter writer = new OutputStreamWriter(outputStream);
    
    for (int i = 0; i < components.length; i++){ 
component = components[i]; 

if (component instanceof JLabel) 
{ 

System.out.println("Out : "+((JLabel) component).getText());
writer.write(((JLabel) component).getText().trim());
writer.write("\n");

} else if (component instanceof JPanel)
{
    Component[] SubComponents = ((JPanel) component).getComponents();
    //System.out.println(" Sub Size :"+SubComponents.length);
    Component SubComponent = null;
    
    for (int t = 0; t < SubComponents.length; t++) 
{ 
SubComponent = SubComponents[t]; 

    if (SubComponent instanceof JTextField) 
        {
            System.out.println("Out_else textField  : "+((JTextField) SubComponent).getText());
            //data.concat(((JTextField) SubComponent).getText().trim().toString());
            //System.out.println(" DATA TextField: "+data);
    writer.write(((JTextField) SubComponent).getText().toString());    
        } else if (SubComponent instanceof JLabel)
        {
            System.out.println("Out_else LableText  : "+((JLabel) SubComponent).getText());
            writer.write(((JLabel) SubComponent).getText().toString());
        //    data.concat(((JLabel) SubComponent).getText());
        //    System.out.println(" DATA TextLable: "+data);
        }
    //System.out.println(" DATA General: "+data);
    //writer.write(data.toString());
    //writer.write("\n");
    //data="";
}
    writer.write("\n");
    //System.out.println("Out_else : "+component.getName());
}
}
    
//        for (int r=0;r<textArea.getLineCount();r++){
//            writer.write(textArea.getText().substring(textArea.getLineStartOffset(r), textArea.getLineEndOffset(r)));
//            }





                writer.flush();
      
                writer.close();
                                        
                                    
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(MakeTable.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                            
           
                                
			}
		});
        
        //for adding the action listener for the button to dispose the frame
        OKButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                
                //System.out.println("JEditor Output : "+pane.getText());
                dispose();
            }
        });
        //for setting the visible to true
        setVisible(true);
        //show the internal frame
        pack();
    }
}
