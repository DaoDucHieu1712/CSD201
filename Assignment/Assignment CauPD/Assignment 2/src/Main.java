/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tree.BSTree;
import Manager.*;
import java.io.IOException;

/**
 *
 * @author Kien
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BSTree bt = new BSTree();

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.loadDataBook(bt);
                    break;
                case 2:
                    Manager.inputInsert(bt);
                    break;
                case 3:
                    Manager.inorderTraverse(bt);
                    break;
                case 4:
                    Manager.bfTraverse(bt);
                    break;
                case 5:
                    Manager.inorderTraverseToFile(bt);
                    break;
                case 6:
                    Manager.searchByCode(bt);
                    break;
                case 7:
                    Manager.deleteByCode(bt);
                    break;
                case 8:
                    Manager.balance(bt);
                    break;
                case 9:
                    Manager.countBook(bt);
                    break;
                case 10:
                    BSTree bt1 = new BSTree();
                    Manager.loadDataBook(bt1);
                    Manager.bfTraverse(bt1);
                    System.out.println("---------------------------------------");
                    Manager.inorderTraverse(bt1);
                    break;
                case 11:
                    BSTree bt2 = new BSTree();
                    Manager.loadDataBook(bt2);
                    Manager.f2(bt2);
                    Manager.bfTraverse(bt2);
                    break;
                case 12:
                    BSTree bt3 = new BSTree();
                    Manager.loadDataBook(bt3);
                    Manager.f3(bt3);
                    Manager.bfTraverse(bt3);
                    break;
                case 13:
                    BSTree bt4 = new BSTree();
                    Manager.loadDataBook(bt4);
                    Manager.f4(bt4);
                    Manager.bfTraverse(bt4);
                    break;
                case 14:
                    BSTree bt5 = new BSTree();
                    Manager.loadDataBook(bt5);
                    Manager.bfTraverse(bt5);
                    //Manager.balance(bt5);
                    Manager.f5(bt5);
                    System.out.println("After balance");
                    Manager.bfTraverse(bt5);
                    break;

            }
        }
    }

}
