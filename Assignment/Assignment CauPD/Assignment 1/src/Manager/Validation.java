/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import LinkedList.MyBookList;
import LinkedList.Reader_List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    public final static Scanner sc = new Scanner(System.in);
    
    public static int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + min + "-" + max);
                System.out.println("Enter again");
            }
        }
    }
    
    public static double checkInputDouble(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + min + "-" + max);
                System.out.println("Enter again");
            }
        }
    }
    
    public static int checkYear() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1900 || result > 2100) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + 1900 + "-" + 2100);
                System.out.println("Enter again");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
                return result;
            } catch (NullPointerException n) {
                System.out.print("Enter again: ");
                System.err.println("Please input String!");
            }
        }
    }
    
    public static boolean checkCodeBook(MyBookList mlb, String bCode){
        for (int i = 0; i < mlb.size(); i++) {
            if(mlb.get(i).getBcode().equals(bCode)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkCodeReader(Reader_List mcl, String rCode){
        for (int i = 0; i < mcl.size(); i++) {
            if(mcl.get(i).getRcode().equals(rCode)){
                return false;
            }
        }
        return true;
    }
}
