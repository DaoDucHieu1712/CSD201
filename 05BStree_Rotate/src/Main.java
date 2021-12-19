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
        int[] a={5,3,9,1,4,2};
        BSTree t=new BSTree();
        t.insertMany(a);
//        System.out.println("1. Pre-order traversal");
//        t.preOrder(t.root);
//        System.out.println();
//        System.out.println("2. In-order traversal");
//        t.inOrder(t.root);
//        System.out.println();
//        System.out.println("3. Post-order traversal");
//        t.postOrder(t.root);
//        System.out.println();
        System.out.println("1. Breadth-first traversal");
        t.breadth(t.root);
        System.out.println();
        System.out.println("2. Test rotate right");
        t.root=t.rotateRight(t.root);
        t.breadth(t.root);
        System.out.println();
    }
}
 