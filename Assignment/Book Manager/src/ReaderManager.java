
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 11/08/2021    1.0            Vanhv   
 */
/**
 *
 * @author vanhv
 */
public class ReaderManager {

    Validation v = new Validation();
    private ReaderNode head;
    private ReaderNode tail;

    ReaderManager() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void visit(ReaderNode p) {
        System.out.println(p.info);
    }

    void traverse() {
        ReaderNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addLast(Reader reader) {
        ReaderNode q = new ReaderNode(reader);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    ReaderNode searchNodeByCode(String code) {
        ReaderNode p = head;
        while (p != null) {
            if (String.valueOf(p.info.getrCode()).equalsIgnoreCase(code)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void searchByCode(String code) {
        ReaderNode p = head;
        System.out.println("rCode      Name      Year");
        while (p != null) {
            if (String.valueOf(p.info.getrCode()).equalsIgnoreCase(code)) {
                visit(p);
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

    void delete(ReaderNode q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            deleteFirst();
            return;
        }
        ReaderNode find = head;
        while (find != null && find.next != q) {
            find = find.next;
        }
        if (find == null) {
            return;
        }
        ReaderNode qNext = q.next;
        find.next = qNext;
        if (find.next == null) {
            tail = find;
        }
    }

    void deleteByCode(String code) {
        ReaderNode root = head;
        while (root != null) {
            ReaderNode p = searchNodeByCode(code);
            delete(p);
            root = root.next;
        }
    }

    ReaderNode findMaxCode() {
        if (isEmpty()) {
            return null;
        }
        ReaderNode q = null;
        ReaderNode p = head;
        int x;
        x = p.info.getrCode();
        p = p.next;
        while (p != null) {
            if (p.info.getrCode() > x) {
                q = p;
                x = p.info.getrCode();
            }
            p = p.next;
        }
        return (q);
    }

    int size() {
        int i = 0;
        ReaderNode p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    //====================
    void loadFile(String fname) throws IOException {
        BufferedReader br;
        try (FileReader fr = new FileReader(fname)) {
            br = new BufferedReader(fr);
            String s;
            String a[];
            Reader reader;
            int rCode;
            String name;
            int year;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                rCode = Integer.valueOf(a[0].trim());
                name = a[1].trim();
                year = Integer.valueOf(a[2].trim());

                reader = new Reader(rCode, name, year);
                if (searchNodeByCode(String.valueOf(reader.getrCode())) == null) {
                    addLast(reader);
                }
            }
        }
        br.close();
    }
    //=================================

    void loadSave(String fname) throws IOException {
        try (FileWriter fw = new FileWriter(fname); PrintWriter pw = new PrintWriter(fw)) {
            ReaderNode p = head;
            while (p != null) {
                int code = p.info.getrCode();
                String name = p.info.getName();
                int year = p.info.getbYear();
                pw.printf("%-8s | %-8s | %-8s \r\n", code, name, year);
                p = p.next;
            }
        }
    }
    //=========================
    String fname = "reader/reader.txt";
    Scanner sc = new Scanner(System.in);

    Reader getReader() {
        int rCode = 0;
        if (isEmpty()) {
            rCode = 0;
        } else {
            rCode = findMaxCode().info.getrCode() + 1;
        }
        String name = v.getString("Name : ", "Please enter character!", "[a-zA-Z0-9]+");
        int year = v.getInt("Year :", "Must between 1900 and 2010", 1900, 2010);
        Reader reader = new Reader(rCode, name, year);
        return reader;
    }

    void f1() throws IOException {
        clear();
        System.out.println("rCode      Name      Year");
        loadFile(fname);
        traverse();
    }

    void f2() throws IOException {
        Reader reader = getReader();
        if (searchNodeByCode(String.valueOf(reader.getrCode())) == null) {
            addLast(reader);
            System.err.println("ADD SUCCESS !!");
            return;
        }
        System.err.println("Book is exist !");
    }

    void f3() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        traverse();
    }

    void f4() throws IOException {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        String filename = v.getString("File name :", "File name format Error", "[a-zA-Z0-9]+");
        loadSave("reader/" + filename + ".txt");
        System.err.println("SAVED");
    }

    void f5() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        System.out.print("rCode : ");
        String rcode = sc.nextLine();
        if (searchNodeByCode(rcode) != null) {
            searchByCode(rcode);
            return;
        }
        System.err.println("Book not found");
    }

    void f6() {
        if (isEmpty()) {
            System.err.println("Data is Empty");
            return;
        }
        System.out.print("rCode : ");
        String rcode = sc.nextLine();
        if (searchNodeByCode(rcode) != null) {
            deleteByCode(rcode);
            traverse();
            return;
        }
        System.err.println("Book not found");
    }

    public static void main(String[] args) throws IOException {
        ReaderManager r = new ReaderManager();
        r.f1();
        //r.f2();
        r.traverse();
        // r.f4();
        r.f5();
        r.f6();
    }
}
