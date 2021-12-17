/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 10/08/2021    1.0            Vanhv   
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class BookManager {

    Validation v = new Validation();
    Node head;
    Node tail;

    BookManager() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void visit(Node p) {
        System.out.println(p.info);
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addLast(Book book) {
        Node q = new Node(book);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addFirst(Book book) {
        head = new Node(book, head);
        if (tail == null) {
            tail = head;
        }
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    void insertAfterPos(Node q, Book book) {
        if (q == null) {
            return;
        }
        Node qNext = q.next;
        Node pNew = new Node(book, qNext);
        q.next = pNew;
        if (tail == q) {
            tail = pNew;
        }
    }

    Node searchNodeByCode(String code) {
        Node p = head;
        while (p != null) {
            if (p.info.getbCode().equalsIgnoreCase(code)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void searchByCode(String code) {
        Node p = head;
        System.out.println("Code      Title        Quantity    Lended     Price      Value");
        while (p != null) {
            if (p.info.getbCode().equalsIgnoreCase(code)) {
                visitBefore(p);
            }
            p = p.next;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void delete(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            deleteFirst();
            return;
        }
        Node find = head;
        while (find != null && find.next != q) {
            find = find.next;
        }
        if (find == null) {
            return;
        }
        Node qNext = q.next;
        find.next = qNext;
        if (find.next == null) {
            tail = find;
        }
    }

    void deleteByCode(String code) {
        Node root = head;
        while (root != null) {
            Node p = searchNodeByCode(code);
            delete(p);
            root = root.next;
        }
    }

    void updatePriceByCode(String code,int price ){
        Node root  = head;
        while(root != null){
            Node p = searchNodeByCode(code);
            p.info.setPrice(price);
            root = root.next;
        }
    }
    void sortByCodeDEC() {
        Node pi, pj;
        Book b;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getbCode().compareTo(pj.info.getbCode()) > 0) {
                    b = pj.info;
                    pj.info = pi.info;
                    pi.info = b;
                }
            }
        }
    }

    void sortByCodeINC() {
        Node pi, pj;
        Book b;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getbCode().compareTo(pj.info.getbCode()) < 0) {
                    b = pj.info;
                    pj.info = pi.info;
                    pi.info = b;
                }
            }
        }
    }
    //==============

    void visitBefore(Node p) {
        double value = p.info.getQuantity() * p.info.getPrice();
        String dp = String.format("%-5s   | %-12s | %-8s | %-8s | %-8s | %-8.1f",
                p.info.getbCode(), p.info.getTitle(), p.info.getQuantity(),
                p.info.getLended(), p.info.getPrice(), value);
        System.out.println(dp);
    }

    void display() {
        Node p = head;
        System.out.println("Code      Title        Quantity    Lended     Price      Value");
        while (p != null) {
            visitBefore(p);
            p = p.next;
        }
        System.out.println();
    }

    void visitNEW(Node p) {
        String dp = String.format("%-5s  %-12s  %-8s  %-8s  %-8.0f ",
                p.info.getbCode(), p.info.getTitle(), p.info.getQuantity(),
                p.info.getLended(), p.info.getPrice());
        System.out.println(dp);
    }

    void displayTravel() {
        Node p = head;
        while (p != null) {
            visitNEW(p);
            p = p.next;
        }
        System.out.println();
    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }
//================================

    void loadFile(String fname) throws IOException {
        BufferedReader br;
        try (FileReader fr = new FileReader(fname)) {
            br = new BufferedReader(fr);
            String s;
            String a[];
            Book book;
            String bcode, title;
            int quantity, lended;
            int price;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                bcode = a[0].trim();
                title = a[1].trim();
                quantity = Integer.valueOf(a[2].trim());
                lended = Integer.valueOf(a[3].trim());
                price = Integer.valueOf(a[4].trim());
                book = new Book(bcode, title, quantity, lended, price);
                if (searchNodeByCode(book.getbCode()) == null) {
                    addLast(book);
                }
            }
        }
        br.close();
    }

    //=================================
    void loadSave(String fname) throws IOException {
        try (FileWriter fw = new FileWriter(fname); PrintWriter pw = new PrintWriter(fw)) {
            Node p = head;
            while (p != null) {
                String code = p.info.getbCode();
                String title = p.info.getTitle();
                int quantity = p.info.getQuantity();
                int lended = p.info.getLended();
                double price = p.info.getPrice();
                pw.printf("%5s   | %-12s | %-8s | %-8s | %-8s \r\n", code, title, quantity, lended, price);
                p = p.next;
            }
        }
    }

    //==============
    Scanner sc = new Scanner(System.in);

    Book getBook() {
        String bcode = v.getString("Code : ", "Please enter character!", "[a-zA-Z0-9]+");
        String title = v.getString("Title : ", "Please enter character!", "[a-zA-Z0-9]+");
        int quantity = v.getInt_2("Quantity : ", "Quantity must be greater than 0");
        int lended = v.getInt_2("Lending : ", "Lending must be greater than 0");
        double price = v.getDouble("Price : ", "Quantity must be greater than 0");

        Book book = new Book(bcode, title, quantity, lended, price);
        return book;
    }
    String file1 = "book/book.txt";

    void f1() throws IOException {
        clear();
        System.out.println("Code      Title        Quantity       Price");
        loadFile(file1);
        traverse();
    }

    void f2() throws IOException {
        Book book = getBook();
        if (searchNodeByCode(book.getbCode()) == null) {
            addLast(book);
            System.err.println("ADD SUCCESS !!");
            return;
        }
        System.err.println("Book is exist !");
    }

    void f3() throws IOException {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        display();
    }

    void f4() throws IOException {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        String filename = v.getString("File name :", "Format Error", "[a-zA-Z0-9]+");
        loadSave("book/" + filename + ".txt");
        System.err.println("SAVED");
    }

    void f5() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        System.out.print("bCode : ");
        String bcode = sc.nextLine();
        if (searchNodeByCode(bcode) != null) {
            searchByCode(bcode);
            return;
        }
        System.err.println("Book not found");
    }

    void f6() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        System.out.print("bCode : ");
        String bcode = sc.nextLine();
        if (searchNodeByCode(bcode) != null) {
            deleteByCode(bcode);
            display();
            System.err.println("DELETED !!");
            return;
        }
        System.err.println("Book not found");
    }

    void f7() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        System.out.print(""
                + "1. Decrease\n"
                + "2. Increase\n");
        int choice = v.getInt("\tOption :", "Option in to [1, 2]", 1, 2);
        switch (choice) {
            case 1: {
                sortByCodeDEC();
                break;
            }
            default: {
                sortByCodeINC();
                break;
            }
        }
        display();
    }

    void f8() {
        Book book = getBook();
        if (searchNodeByCode(book.getbCode()) == null) {
            addFirst(book);
            System.err.println("ADD SUCCESS !!");
            return;
        }
        System.err.println("Book is exist !");
    }

    void f9() {
        if (isEmpty()) {
            System.err.println("Not exist a position to add after");
            return;
        }
        int index = v.getInt("Position : ", "Position into [1," + size() + "]", 1, size());
        Book book = getBook();
        insertAfterPos(pos(index - 1), book);
        display();
        System.err.println("INSERT AFTER SUCCESS !!");
    }

    void f10() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        int index = v.getInt("Position : ", "Position into [1," + size() + "]", 1, size());
        delete(pos(index - 1));
        display();
        System.err.println("DELETED !!");
    }

    void f11() throws IOException {
        clear();
        loadFile(file1);
        displayTravel();
    }

    void f12() throws IOException {
        Book book = new Book("6", "E", 3, 2, 2);
        if (searchNodeByCode(book.getbCode()) == null) {
            addLast(book);
            System.err.println("ADD SUCCESS !!");
            displayTravel();
            return;
        }
        System.err.println("Book is exist !");
        //displayTravel();
    }

    void f13() {
        updatePriceByCode("3", 8);
        displayTravel();
    }

  

    void f14() {
        deleteByCode("2");
        displayTravel();
    }

    void sortByQuantityDEC() {
        Node pi, pj;
        Book b;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getQuantity() > pj.info.getQuantity()) {
                    b = pj.info;
                    pj.info = pi.info;
                    pi.info = b;
                }
            }
        }
    }

    void f15() {
        sortByQuantityDEC();
        displayTravel();
    }
}
