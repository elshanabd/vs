/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.regex.Pattern;


/**
 *
 * @author Elshan.Abdullayev
 */
public class Birth_date_checking {
    
    public static void main( String args[] ) {
    
    System.out.println("35/17/1985 --- Output "+
    Pattern.matches("[0-9Xx]{2}/[0-9Xx]{2}/[0-9Xx]{4}","35/17/1985"));//invalid date 
    
    System.out.println("30/10/1985 --- Output "+
    Pattern.matches("[0-9Xx]{2}/[0-9Xx]{2}/[0-9Xx]{4}","30/10/1985"));//normal date
    
    System.out.println("30.10.1985 --- Output "+
    Pattern.matches("[0-9Xx]{2}/[0-9Xx]{2}/[0-9Xx]{4}","30.10.1985"));//dd.mm.yyyy format date
    
    System.out.println("Null --- Output "+
    Pattern.matches("[0-9Xx]{2}/[0-9Xx]{2}/[0-9Xx]{4}",""));//null date
    
    
    }
    
}
