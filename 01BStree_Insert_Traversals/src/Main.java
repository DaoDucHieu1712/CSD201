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
        int[] a={16,6,18,1,10,25,8,12,22};
        BSTree t=new BSTree();
        t.insertMany(a);
        for (int i = 0; i < 9; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        System.out.println("1. Pre-order traversal");
        t.preOrder(t.root);
        System.out.println();
        System.out.println("2. Test rotate to right");
        t.root=t.rotateRight(t.root);
        t.breadth(t.root);
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
