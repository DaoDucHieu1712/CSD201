/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 10/08/2021    1.0            Vanhv   
 */

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vanhv
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Validation v = new Validation();
        Manager manager = new Manager();

        int choice;
        do {
            System.out.println("------------MAIN MENU------------");
            System.out.println("1.  Book Manager");
            System.out.println("2.  Reader Manager");
            System.out.println("3.  Lending Manager");
            System.out.println("0.  Exit");
            System.out.println("\n\t\t----------------");
            choice = v.getInt("Option : ", "Option into [1, 3]", 1, 3);
            switch (choice) {
                case 1: {
                    manager.bookManager();
                    break;
                }
                case 2: {
                    manager.readerManager();
                    break;
                }
                case 3: {

                }
                default: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 0);
    }
}
