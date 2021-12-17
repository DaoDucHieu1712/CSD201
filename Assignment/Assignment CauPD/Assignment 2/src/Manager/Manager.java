/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Book;
import Tree.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kien
 */
public class Manager {

    private static final String BOOK_URL = "book2.txt";

    public static int menu() {
        System.out.println("1.      Load data from file");
        System.out.println("2.      Input & insert data");
        System.out.println("3.      In-order traverse");
        System.out.println("4.      Breadth-first traverse");
        System.out.println("5.      In-order traverse to file");
        System.out.println("6.      Search by bcode");
        System.out.println("7.      Delete by bcode by copying");
        System.out.println("8.      Simply balancing");
        System.out.println("9.      Count number of books");
        System.out.println("10.     f1()");
        System.out.println("11.     f2()");
        System.out.println("12.     f3()");
        System.out.println("13.     f4()");
        System.out.println("14.     f5()");
        System.out.println("Your choice: ");
        int choice = Validate.checkInputInt(1, 14);
        return choice;
    }

    public static void loadDataBook(BSTree bt) {
        try {
            FileReader fr = new FileReader(BOOK_URL);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] a;
            Book x;
            String xCode, xTitle;
            int xQuality, xLended;
            double xPrice;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                xCode = a[0].trim();
                xTitle = a[1].trim();
                xQuality = Integer.parseInt(a[2].trim());
                xLended = Integer.parseInt(a[3].trim());
                xPrice = Double.parseDouble(a[4].trim());
                x = new Book(xCode, xTitle, xQuality, xLended, xPrice);
                bt.insert(x);
            }
            System.out.println("Load successful");
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Load unsuccessful");
        }
    }

    public static void inputInsert(BSTree bt) {
        while (true) {
            System.out.println("Enter bCode");
            String bCode = Validate.checkInputString();
            System.out.println("Enter book title:");
            String title = Validate.checkInputString();
            System.out.println("Enter number of quanlity:");
            int quality = Validate.checkInputInt(0, Integer.MAX_VALUE);
            System.out.println("Enter number of booker:");
            int lended = Validate.checkInputInt(0, Integer.MAX_VALUE);
            System.out.println("Enter depart time:");
            double price = Validate.checkInputDouble(0, Double.MAX_VALUE);
            Book b = new Book(bCode, title, quality, lended, price);
            bt.insert(b);
            System.out.println("Insert successful!");
            return;
        }
    }

    public static void inorderTraverse(BSTree bt) {
        bt.inorder(bt.root);
    }

    public static void bfTraverse(BSTree bt) {
        bt.bfs(bt.root);
    }

    private static void visit(Node p, FileWriter fw) throws IOException {

        fw.write(p.info.getBcode() + " | " + p.info.getTitle() + " | "
                + p.info.getQuality() + " | " + p.info.getLended() + " | "
                + p.info.getPrice() + "\n");

    }

    private static void inOrderFile(Node p, FileWriter fw) throws IOException {
        if (p == null) {
            return;
        }
        inOrderFile(p.left, fw);
        visit(p, fw);
        inOrderFile(p.right, fw);
    }

    public static void inorderTraverseToFile(BSTree bt) throws IOException {

        FileWriter fw = new FileWriter(BOOK_URL);
        inOrderFile(bt.root, fw);
        fw.close();

    }

    public static void searchByCode(BSTree bt) {
        System.out.println("Enter a code: ");
        String code = Validate.checkInputString();
        Node n = BSTree.search(bt.root, code);
        if (n == null) {
            System.out.println("Not found");
        } else {
            System.out.println(n.info);
        }
    }

    public static void deleteByCode(BSTree bt) {
        System.out.println("Enter a code: ");
        String code = Validate.checkInputString();
        bt.deleByCopy(code);
    }

    public static void balance(BSTree bt) {
        bt.bal();
    }

    public static void countBook(BSTree bt) {
        int node = bt.countNode();
        System.out.println("Number of books : " + node);
    }

    public static void f1(BSTree bt) {
        bt.inorder(bt.root);
        bt.bfs(bt.root);
    }
    
    public static void f2(BSTree bt) {
//        System.out.println("Enter a code: ");
//        String code = Validate.checkInputString();
        Node n = BSTree.search(bt.root, "6");
        if (n == null) {
            System.out.println("Not found");
        } else {
            n.info.setDepart_time(9);
        }
    }

    public static void f3(BSTree bt) {
        Node n = BSTree.search(bt.root, "3");
        if (n == null) {
            System.out.println("Not found");
        } else {
            bt.deleByCopy("3");
        }
    }

    public static void f4(BSTree bt) {
        bt.insert(new Book("7", "G", 3, 2, 1));
    }

    public static void f5(BSTree bt) {
       Node n = BSTree.search(bt.root, "3");
        bt.balance(n);
    }
}
