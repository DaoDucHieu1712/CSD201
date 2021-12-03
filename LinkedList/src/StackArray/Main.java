/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackArray;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(13);
        s.push(21);
        s.push(-22);
        s.push(94);
        s.push(123);
        s.pop();
        s.traversal();
        System.out.println("Top : "+ s.top());
        System.out.println("Size : " + s.size());
    }
}
