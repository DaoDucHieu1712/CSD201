/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary;

/**
 *
 * @author Admin
 */
public class Node {

    private int values;
    Node left, right;

    public Node() {
    }

    public Node(int values) {
        this.values = values;
        this.left = this.right = null;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
   
}
