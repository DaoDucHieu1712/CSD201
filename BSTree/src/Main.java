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
        BSTree t = new BSTree();
        int[] a = new int[10];
        while (true) {
            System.out.println("---- Menu ----");
            System.out.println("1.Insert");
            System.out.println("2.Deletion");
            System.out.println("3.Pre-order traversal");
            System.out.println("4.In-order traversal");
            System.out.println("5.Post-order traversal");
            System.out.println("6.Exit");
            int choice = Validate.getChoice("Choice : ", "Invalid !", 1, 6);
            switch (choice) {
                case 1:
                    System.out.println("Add 10 element");
                    for (int i = 0; i < 10; i++) {
                        a[i] = Validate.getInt("Enter element: ", "Invalid !");
                    }
                    t.insertMany(a);
                    System.out.println("");
                    break;
                case 2:
                    int x = Validate.getInt("Enter element you want to delete: ", "Invalid !");
                    t.delete(x);
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Pre-order traversal"); // tien 
                    t.preOrder(t.root);
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("In-order traversal"); // trung thu
                    t.inOrder(t.root);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Post-order traversal");// hau thu 
                    t.postOrder(t.root);
                    System.out.println("");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
