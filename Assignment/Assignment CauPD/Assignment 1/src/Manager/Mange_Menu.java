/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

/**
 *
 * @author Admin
 */
public class Mange_Menu {
   public static int menuBook(){
        System.out.println("1.      Load data from file");
        System.out.println("2.      Input & add to the head");
        System.out.println("3.      Display data");
        System.out.println("4.      Save book list to file");
        System.out.println("5.      Search by bcode");
        System.out.println("6.      Delete by bcode");
        System.out.println("7.      Sort by bcode");
        System.out.println("8.      Input & add to beginning");
        System.out.println("9.      Add after position  k");
        System.out.println("10.     Delete position k");
        System.out.println("11.     f1()");
        System.out.println("12.     f2()");
        System.out.println("13.     f3()");
        System.out.println("14.     f4()");
        System.out.println("15.     f5()");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputInt(1, 15);
        return choice;
    }
    public static int menuReader(){
        System.out.println("1.      Load data from file");
        System.out.println("2.      Input & add to the end");
        System.out.println("3.      Display data");
        System.out.println("4.      Save customer list to file");
        System.out.println("5.      Search by ccode");
        System.out.println("6.      Delete by ccode");
        int choice = Validation.checkInputInt(1, 6);
        return choice;
    } 
    
    public static int menuLender(){
        System.out.println("1.      Input data from file");
        System.out.println("2.      Display data");
        System.out.println("3.      Sort by bcode and rcode");
        System.out.println("4.      Display book\n");
        int choice = Validation.checkInputInt(1, 6);
        return choice;
    }
}
