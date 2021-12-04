/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        int x, y;
        Node q;
        while (true) {
            menu();
            int choice = Validate.getChoice("Enter choice: ", "Invalid !", 1, 10);
            switch (choice) {
                case 1:
                    int n = Validate.getInt("Enter number element you can create: ", "Invalid !");
                    for (int i = 0; i < n; i++) {
                        x = Validate.getInt("Enter element :", "Invalid !");
                        d.addLast(x);
                    }
                    d.traversal();
                    System.out.println("");
                    break;
                case 2:
                    d.checkEmpty();
                    System.out.println("");
                    break;
                case 3:
                    x = Validate.getInt("Enter element :", "Invalid !");
                    d.addLast(x);
                    d.traversal();
                    System.out.println("");
                    break;
                case 4:
                    x = Validate.getInt("Enter element :", "Invalid !");
                    d.addFirst(x);
                    d.traversal();
                    System.out.println("");
                    break;
                case 5:
                    d.removeFirst();
                    d.traversal();
                    System.out.println("");
                    break;
                case 6:
                    d.removeLast();
                    d.traversal();
                    System.out.println("");
                    break;
                case 7:
                    y = Validate.getInt("Enter element you can insert before: ", "Invalid !");
                    q = d.search(y);
                    x = Validate.getInt("Enter the elemnet you can insert before " + y + ":", "Invalid !");
                    d.insertBefore(q, x);
                    d.traversal();
                    System.out.println("");
                    break;
                case 8:
                    y = Validate.getInt("Enter element you can insert before: ", "Invalid !");
                    q = d.search(y);
                    x = Validate.getInt("Enter the elemnet you can insert before " + y + ":", "Invalid !");
                    d.insertAfter(q, x);
                    d.traversal();
                    System.out.println("");
                    break;
                case 9:
                    x = LinkedList.Validate.getInt("Enter the node you can delete: ", "Invalid !");
                    q = d.search(x);
                    d.remove(q);
                    d.traversal();
                    System.out.println("");
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        }

    }

    static void menu() {
        System.out.println("---- Menu ----");
        System.out.println("1.Create Element");
        System.out.println("2.Check Empty");
        System.out.println("3.Add First");
        System.out.println("4.Add Last");
        System.out.println("5.Remove First");
        System.out.println("6.Remove Last");
        System.out.println("7.Insert Before");
        System.out.println("8.Insert After");
        System.out.println("9.Remove Element");
        System.out.println("10.Exit");
    }
}
