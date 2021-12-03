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
        MyList m = new MyList();
        Node q;
        int x,y;
        while (true) {
            menu();
            int choice = Validate.getChoice("Choose: ", "Invalid !", 1, 10);
            switch (choice) {
                case 1:
                    int n = Validate.getInt("Enter number element you can insert: ", "Invalid !");
                    for (int i = 0; i < n; i++) {
                        x = Validate.getInt("Enter x: ", "Invalid !");
                        m.addLast(x);
                    }
                    System.out.println("List : ");
                    m.traversal();
                    System.out.println("");
                    break;
                case 2:
                    m.checkEmpty();
                    System.out.println("");
                    break;
                case 3:
                    x = Validate.getInt("Enter x: ", "Invalid !");
                    m.addFirst(x);
                    m.traversal();
                    System.out.println("");
                    break;
                case 4:
                    x = Validate.getInt("Enter x: ", "Invalid !");
                    m.addLast(x);
                    m.traversal();
                    System.out.println("");
                    break;
                case 5:
                    m.removeFirst();
                    m.traversal();
                    System.out.println("");
                    break;
                case 6:
                    int size = m.size();
                    q = m.pos(size - 1);
                    m.remove(q);
                    m.traversal();
                    System.out.println("");
                    break;
                case 7:
                    y = Validate.getInt("Enter the node you can Insert before: ", "Invalid !");
                    q = m.search(y);
                    x = Validate.getInt("Enter x: ", "Invalid !");
                    m.insertBefore(q, x);
                    m.traversal();
                    System.out.println("");
                    break;
                case 8:
                    y = Validate.getInt("Enter the node you can Insert before: ", "Invalid !");
                    q = m.search(y);
                    x = Validate.getInt("Enter x: ", "Invalid !");
                    m.insertAfter(q, x);
                    m.traversal();
                    System.out.println("");
                    break;
                case 9:
                    x = Validate.getInt("Enter the node you can delete: ", "Invalid !");
                    q = m.search(x);
                    m.remove(q);
                    m.traversal();
                    System.out.println("");
                    break;
                case 10:
                    m.reverse();
                    m.traversal();
                    System.out.println("");
                    break;
                case 11:
                    System.exit(0);
                    break;
            }
        }
    }

    static void menu() {
        System.out.println("---- Menu ----");
        System.out.println("1.Insert Element");
        System.out.println("2.Check Empty");
        System.out.println("3.Add First");
        System.out.println("4.Add Last");
        System.out.println("5.Remove First");
        System.out.println("6.Remove Last");
        System.out.println("7.Insert Before");
        System.out.println("8.Insert Before");
        System.out.println("9.Remove Node");
        System.out.println("10.Reverse");
        System.out.println("11.Exit !");
    }
}
