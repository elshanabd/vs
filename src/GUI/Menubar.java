package GUI;


//import the packages for using the classes in them into the program
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Menubar extends JMenuBar {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the JMenu for the program
    public JMenu fileMenu, helpMenu  ,bookMenu,  tableMenu,  searchMenu,  loanMenu;
    //for creating the JMenuItem for JMenu
    public JMenuItem   exit, open,  addBook,  listBook, viewHelp, aboutUs;
    public JMenuItem   table,  listTable;
    public JMenuItem  searchBooksAndMembers,  borrowBook,  returnBook;
    //for creating an imageIcon
    public ImageIcon[] icons;
    //for creating the name of the image file 16*16
    public String[] imageName16 = {"images/Print16.gif", "images/Exit16.gif",
        "images/Add16.gif", "images/List16.gif", "images/Edit16.gif"
       // , "images/Edit16.gif", "images/Delete16.gif",
       // "images/Information16.gif", "images/Find16.gif", "images/Export16.gif", "images/Import16.gif",
        };

    public Menubar() {
        //for adding book, member, search, loan & help Menus to the menu bar
        this.add(fileMenu = new JMenu("File"));
        this.add(tableMenu = new JMenu("View"));
        this.add(helpMenu = new JMenu("Help"));
        //this.add(searchMenu = new JMenu("Search"));
        //this.add(loanMenu = new JMenu("Loan"));

        /**
         *for setting the Mnemonic
         */
        
        fileMenu.setMnemonic('f');
        helpMenu.setMnemonic('h');
        tableMenu.setMnemonic('v');
        //searchMenu.setMnemonic('s');
        //loanMenu.setMnemonic('l');

        //for setting the image icons
        icons = new ImageIcon[12];
        for (int i = 0; i < imageName16.length; i++) {
            icons[i] = new ImageIcon(ClassLoader.getSystemResource(imageName16[i]));
        }

        //for adding print books & exit
        fileMenu.add(open = new JMenuItem("Open", icons[4]));
        fileMenu.add(exit = new JMenuItem("Exit", icons[1]));
         
        

        //for adding add, list, listAvailble, listBorrowed, edit & remove Books and book information to the bookMenu
        helpMenu.add(viewHelp = new JMenuItem("View Help ", icons[2]));
        helpMenu.add(aboutUs = new JMenuItem("About us", icons[3]));
       

        //for adding add, list, edit & remove Members and member information to the memberMenu
        tableMenu.add(table = new JMenuItem("View Panel", icons[2]));
        tableMenu.add(listTable = new JMenuItem("ViewTable",icons[3]));
        //memberMenu.add(listMember = new JMenuItem("List All Members", icons[3]));
  
        //for adding add, list & remove Members to the memberMenu
        //searchMenu.add(searchBooksAndMembers = new JMenuItem("Search", icons[7]));

        //for adding borrow & return books to the loanMenu
        //loanMenu.add(borrowBook = new JMenuItem("Borrow a Book", icons[8]));
        //loanMenu.add(returnBook = new JMenuItem("Return a Book", icons[9]));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        //searchBooksAndMembers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        viewHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        aboutUs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));


        table.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        listTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
       
// listMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        //borrowBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        //returnBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    }
}
