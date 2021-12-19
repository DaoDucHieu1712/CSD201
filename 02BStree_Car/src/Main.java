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
    public static void main(String[] args) {
        String[] b={"A","B","C","D","E","F","G","H","I"};
        int[] a={16,6,18,1,10,25,8,12,22};
        BSTree t=new BSTree();
        t.insertMany(b,a);
        System.out.println("1. Pre-order traversal");
        t.preOrder(t.root);
        System.out.println();
        System.out.println("2. In-order traversal");
        t.inOrder(t.root);
        System.out.println();
        System.out.println("3. Post-order traversal");
        t.postOrder(t.root);
        System.out.println();
        System.out.println("4. Breadth-first traversal");
        t.breadth(t.root);
        System.out.println();
    }
}
