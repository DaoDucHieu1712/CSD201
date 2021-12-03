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
        System.out.println("1.Thêm phần tử");
        System.out.println("2.Kiểm tra xem danh sách có rỗng hay không ?");
        System.out.println("3.Chèn một phần tử vào đầu danh sách");
        System.out.println("4.Chèn một phần tử vào cuối danh sách");
        System.out.println("5.Xóa phần tử đầu danh sách");
        System.out.println("6.Xóa phần tử cuối danh sách");
        System.out.println("7.Chèn 1 phần tử cho trước vào trước một phần tử cho trước");
        System.out.println("8.Chèn 1 phần tử cho trước vào sau một phần tử cho trước");
        System.out.println("9.Xóa một phần tử cho trước");
        System.out.println("10.Đảo ngược danh sách");
        System.out.println("11.Exit !");
    }
}
