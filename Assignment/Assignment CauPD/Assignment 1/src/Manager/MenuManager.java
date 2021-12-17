/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.*;
import LinkedList.MyBookList;
import LinkedList.Reader_List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class MenuManager {
    private static final String BOOK_URL = "book.txt";
    private static final String BOOK1_URL = "book1.txt";
    private static final String READER_URL = "reader.txt";

    public static int menu() {
        System.out.printf("%-3s%-10s", "", "---MAIN MENU---\n");
        System.out.println("1. Book list");
        System.out.println("2. Reader list");
        System.out.println("3. Lending list");
        System.out.println("0. Exit program");

        int choise = Validation.checkInputInt(0, 3);
        return choise;
    }


    public static void loadBookFromFile(MyBookList mlb) {

        try {
            FileReader fr = new FileReader(BOOK_URL);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] a;
            Book x;
            String xCode, xTitle;
            int xQuantity, xLended;
            double xPrice;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                xCode = a[0].trim();
                xTitle = a[1].trim();
                xQuantity = Integer.parseInt(a[2].trim());
                xLended = 0;
                xPrice = Double.parseDouble(a[3].trim());
                x = new Book(xCode, xTitle, xQuantity, xLended, xPrice);
                mlb.addLast(x);
            }
            fr.close();
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Data loaded!");
    }

    //Input & add to the head
    public static void addToEnd1(MyBookList mlb) {
        while (true) {
            System.out.println("Enter bCode");
            String bCode = Validation.checkInputString();
            if (!Validation.checkCodeBook(mlb, bCode)) {
                System.out.println("Duplicates code");
                continue;
            }
            System.out.println("Enter book title:");
            String title = Validation.checkInputString();
            System.out.println("Enter number of quantity:");
            int quantity = Validation.checkInputInt(0, Integer.MAX_VALUE);
            System.out.println("Enter number of lended:");
            int lended = Validation.checkInputInt(0, Integer.MAX_VALUE);
            System.out.println("Enter price of book:");
            double price = Validation.checkInputDouble(0, Double.MAX_VALUE);
            System.out.println("Enter  arrival time:");
            Book b = new Book(bCode, title, quantity, lended, price);
            mlb.addLast(b);
            System.out.println("Add successful!");
            return;
        }
    }


    public static void displayBook(MyBookList mlb) {
        System.out.println("List Bus:");
        mlb.traverse();
    }

    public static void saveToFile1(MyBookList mlb) {
        System.out.println("");
        try {
            FileWriter fw = new FileWriter(BOOK_URL);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < mlb.size(); i++) {
                Book b = mlb.get(i);
                pw.printf("%s|%s|%d|%d|%f\n", b.getBcode(), b.getTitle(),
                        b.getQuantity(), b.getLended(), b.getPrice());
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
        }
    }


    public static void searchByBCode(MyBookList mlb) {
        System.out.println("Enter a code to search");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                System.out.println(mlb.get(i));
                check = true;
            }
        }
        if (!check) {
            System.out.println("Id not found");
        }
    }

    public static void deleteByBCode(MyBookList mlb) {
        System.out.println("Enter a code to delete");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                mlb.deleteAt(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Id not found");
        } else {
            System.out.println("Delete successful.");
        }
    }

   
    public static void sortByBCode(MyBookList mlb) {
        mlb.sortByBCode();
        System.out.println("List after sort:");
        displayBook(mlb);
    }

 
    public static void addBeforePosition(MyBookList mlb) {
        System.out.println("Enter a position to add:");
        int k = Validation.checkInputInt(0, mlb.size());
        while (true) {
            String bCode = Validation.checkInputString();
            if (!Validation.checkCodeBook(mlb, bCode)) {
                System.out.println("Duplicates code");
                continue;
            }
            String title = Validation.checkInputString();
            int quantity = Validation.checkInputInt(0, Integer.MAX_VALUE);
            int lended = Validation.checkInputInt(0, Integer.MAX_VALUE);
            double price = Validation.checkInputDouble(0, Double.MAX_VALUE);
            Book b = new Book(bCode, title, quantity, lended, price);
            mlb.insertBefore(k, b);
            break;
        }
    }

   
    public static void deleteBeforeBCode(MyBookList mlb) {
        System.out.println("Enter a b code :");
        String bCode = Validation.checkInputString();
        boolean check = false;
        for (int i = 0; i < mlb.size(); i++) {
            if (mlb.get(i).getBcode().equalsIgnoreCase(bCode)) {
                mlb.deleteAt(i - 1);
                check = true;
            }
        }
        if (!check) {
            System.out.println("B code not found.");
        }
    }

    public static void deleteAtPositionK(MyBookList mlb) {
        
    }
    
    public static void f1(MyBookList mlb) {
        try {
            FileReader fr = new FileReader(BOOK1_URL);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] a;
            Book x;
            String xCode, xTitle;
            int xQuantity;
            double xPrice;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[,]");
                xCode = a[0].trim();
                xTitle = a[1].trim();
                xQuantity = Integer.parseInt(a[2].trim());
                xPrice = Double.parseDouble(a[3].trim());
                x = new Book(xCode, xTitle, xQuantity, xPrice);
                mlb.addLast(x);
            }
            fr.close();
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("List Bus:");
        mlb.traverse();
    }

    public static void f2(MyBookList mlb) {
        
    }
    
    public static void f3(MyBookList mlb) {
        
    }
    
    public static void f4(MyBookList mlb) {
        
    }
    
    public static void f5(MyBookList mlb) {
        
    }
   
    public static void loadReaderFromFile(Reader_List mlc) {
        try {

            FileReader fr = new FileReader(READER_URL);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] a;
            Reader x;
            String xCode, xName;
            int xYear;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                xCode = a[0].trim();
                xName = a[1].trim();
                xYear = Integer.parseInt(a[2].trim());
                x = new Reader(xCode, xName, xYear);
                mlc.addLast(x);
            }
            fr.close();
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Data loaded!");
    }

  
    public static void addToEnd2(Reader_List mlc) {
        while (true) {
            System.out.println("Enter reader code:");
            String rcode = Validation.checkInputString();
            if (!Validation.checkCodeReader(mlc, rcode)) {
                System.out.println("Duplicate code.");
                continue;
            }
            System.out.println("Enter reader name:");
            String name = Validation.checkInputString();
            System.out.println("Enter year:");
            int byear = Validation.checkYear();
            Reader c = new Reader(rcode, name, byear);
            mlc.addLast(c);
            System.out.println("Add successful!");
        }
    }
    
    public static void saveToFile2(Reader_List mlc){
        System.out.println("");
        try {
            FileWriter fw = new FileWriter(READER_URL);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < mlc.size(); i++) {
                Reader r = mlc.get(i);
                pw.printf("%s|%s|%d\n", r.getRcode(), r.getName(), r.getByear());
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
        }
    }

   
    public static void displayReader(Reader_List mlc) {
        System.out.println("List Reader:");
        mlc.traverse();
    }
 

    public static void searchByRCode(Reader_List mlc) {
        System.out.println("Enter a code to search");
        String rCode = Validation.checkInputString();
        for (int i = 0; i < mlc.size(); i++) {
            if (mlc.get(i).getRcode().equalsIgnoreCase(rCode)) {
                System.out.println(mlc.get(i));
            }
        }
    }


    public static void deleteByRCode(Reader_List mlc) {
        System.out.println("Enter a code to delete");
        String rCode = Validation.checkInputString();
        for (int i = 0; i < mlc.size(); i++) {
            if (mlc.get(i).getRcode().equalsIgnoreCase(rCode)) {
                mlc.deleteAt(i);
            }
        }
    }


}
