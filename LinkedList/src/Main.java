
/*
* Copyright(C) 2021, LinkedList
* T.LinkedList:
* Basic
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2021-12-01      1.0                 Duc Hieu         Main
 */
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyList t = new MyList();
        Node p, q;
        Person x;
        int k;
        String[] a = {"A", "C", "B", "E", "D"};
        int[] b = {1, 2, 3, 4, 5};

        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Show List and AddLast");
            System.out.println("2. AddFrist");
            System.out.println("3. Insert After");
            System.out.println("4. Before After");
            System.out.println("5. Reverse");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choose = 0;

            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choose = 6;
            }
            switch (choose) {
                case 1:
                    t.clear();
                    t.addMany(a, b);
                    t.traverse();
                    break;
                case 2:
                    t.clear();
                    t.addMany(a, b);
                    t.traverse();
                    System.out.println("After addFirst:");
                    x = new Person("H", 20);
                    t.addFirst(x);
                    t.traverse();
                    break;
                case 3:
                    t.clear();
                    t.addMany(a, b);
                    t.traverse();
                    x = new Person("T", 30);
                    q = t.searchByName("B");
                    System.out.println("After Insert: ");
                    t.insertAfter(q, x);
                    t.traverse();
                    break;
                case 4:
                    t.clear();
                    t.addMany(a, b);
                    t.traverse();
                    x = new Person("T", 30);
                    q = t.searchByName("B");
                    System.out.println("Before Insert: ");
                    t.insertBefore(q, x);
                    t.traverse();
                    break;
                case 5:
                    t.clear();
                    t.addMany(a, b);
                    t.traverse();
                    System.out.println("After reverse");
                    t.reverse();
                    t.traverse();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid !");
                    System.exit(0);
                    break;
            }
        }
    }
}
