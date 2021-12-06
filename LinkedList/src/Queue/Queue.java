/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Queue {
    int Q[];
    int MAX = 100;
    int f, l;

    Queue() {
        Q = new int[MAX];
        f = l = -1;
    }

    void clear() {

    }

    boolean isEmpty() {
        return f == -1;
    }

    void full() {
        int x = 0;
        if ((f > 0) && (l == MAX - 1)) {
            for (int i = f; i <= l; i++) {
                Q[x] = Q[f];
                x++;
            }
        }
    }

    void enqueue(int x) {
        if ((f == 0) && (l == MAX - 1)) {
            System.out.println("Queue is full");
        } else {
            l++;
            Q[l] = x;
            if (f == -1) {
                f = 0;
            }
        }
    }

    int dequeue() {
        int x = -1;
        if (isEmpty()) {
            System.out.println("Q is empty");
        } else {
            x = Q[f];
            f++;
        }
        return x;
    }

    void input() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number elements: n = ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter: x = ");
            int x = sc.nextInt();
            enqueue(x);
        }
    }

    void traversal() {
        while (f <= l) {
            int x = dequeue();
            System.out.print(x + " ");
        }
        System.out.println("");
    }
}
