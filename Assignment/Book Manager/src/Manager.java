
import java.io.IOException;
import java.util.Scanner;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 11/08/2021    1.0            Vanhv   
 */
/**
 *
 * @author vanhv
 */
public class Manager {

    Scanner sc = new Scanner(System.in);

    void bookManager() throws IOException {
        BookManager m = new BookManager();
        int choice;
          System.out.println("===================BOOK MANAGER===================\n"
                    + "1.  Load data from file\n"
                    + "2.  Input & add to the end\n"
                    + "3.  Display data\n"
                    + "4.  Save book list to file\n"
                    + "5.  Search by bcode\n"
                    + "6.  Delete by bcode\n"
                    + "7.  Sort by bcode\n"
                    + "8.  Input & add to beginning\n"
                    + "9.  Add after position  k\n"
                    + "10. Delete position k\n"
                    + "11. LOAD k\n"
                    + "12. ADD WITHOUT LOAD k\n"
                    + "13. UPDATE BY SEARCH k\n"
                    + "14. DELETE BY CODE\n"
                    + "15. SORT BY QUANTITY k\n"
                    + "0.  Back to Main"
                    + "\n===================");

            System.out.println("\n\t\t----------------");
        do {
          
            System.out.print("Option : ");
            choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1: {
                    m.f1();
                    break;
                }
                case 2: {
                    m.f2();
                    break;
                }
                case 3: {
                    m.f3();
                    break;
                }
                case 4: {
                    m.f4();
                    break;
                }
                case 5: {
                    m.f5();
                    break;
                }
                case 6: {
                    m.f6();
                    break;
                }
                case 7: {
                    m.f7();
                    break;
                }
                case 8: {
                    m.f8();
                    break;
                }
                case 9: {
                    m.f9();
                    break;
                }
                case 10: {
                    m.f10();
                    break;
                }
                case 11: {
                    m.f11();
                    break;
                }
                case 12: {
                    m.f12();
                    break;
                }
                case 13: {
                    m.f13();
                    break;
                }
                case 14: {
                    m.f14();
                    break;
                }
                case 15: {
                    m.f15();
                    break;
                }
            }
        } while (choice != 0);
    }

    void readerManager() throws IOException {
        ReaderManager m = new ReaderManager();
        int choice;
        do {
            System.out.println("===================READER MANAGER===================\n"
                    + "1.  Load data from file\n"
                    + "2.  Input & add to the end\n"
                    + "3.  Display data\n"
                    + "4.  Save reader list to file\n"
                    + "5.  Search by rcode\n"
                    + "6.  Delete by rcode\n"
                    + "0.  Back to Main"
                    + "\n===================");

            System.out.println("\n\t\t----------------");
            System.out.print("Option : ");
            choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1: {
                    m.f1();
                    break;
                }
                case 2: {
                    m.f2();
                    break;
                }
                case 3: {
                    m.f3();
                    break;
                }
                case 4: {
                    m.f4();
                    break;
                }
                case 5: {
                    // m.f5();
                    break;
                }
                case 6: {
                    // m.f6();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (choice != 0);
    }
}
