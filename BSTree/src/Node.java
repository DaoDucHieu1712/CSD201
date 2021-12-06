/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Node {

    int infor;
    Node left, right;

    Node() {
    }

    Node(int x) {
        infor = x;
        left = right = null;
    }
}
