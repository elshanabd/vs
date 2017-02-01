/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author esmira_bayramova
 */
public class Recursiya {
  
    public static void main(String args[]) {
         
     
myRecursiveMethod(100);
} 
      
    public static int myRecursiveMethod (int x)
{
 
  if (x >0){
    System.out.println(" X = "+ myRecursiveMethod(x-1));
  }
  return x;
}

}
