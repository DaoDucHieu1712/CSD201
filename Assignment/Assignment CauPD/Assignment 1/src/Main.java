/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import LinkedList.MyBookList;
import LinkedList.Reader_List;
import Manager.Mange_Menu;
import Manager.MenuManager;
import static java.lang.System.exit;
/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        MyBookList mlb = new MyBookList();
        Reader_List mlc = new Reader_List();
        while (true) {
            int choice = MenuManager.menu();
            switch (choice) {
                case 1:
                    int book_choice = Mange_Menu.menuBook();
                    switch (book_choice) {
                        case 1:
                            MenuManager.loadBookFromFile(mlb);
                            break;
                        case 2:
                            MenuManager.addToEnd1(mlb);
                            break;
                        case 3:
                            MenuManager.displayBook(mlb);
                            break;
                        case 4:
                            MenuManager.saveToFile1(mlb);
                            break;
                        case 5:
                            MenuManager.searchByBCode(mlb);
                            break;
                        case 6:
                            MenuManager.deleteByBCode(mlb);
                            break;
                        case 7:
                            MenuManager.sortByBCode(mlb);
                            break;
                        case 8:
                            MenuManager.addBeforePosition(mlb);
                            break;
                        case 9:
                            MenuManager.deleteBeforeBCode(mlb);
                            break;
                        case 10:
                            MenuManager.deleteAtPositionK(mlb);
                            break;
                        case 11:
                            MenuManager.f1(mlb);
                            break;
                        case 12:
                            MenuManager.f2(mlb);
                            break;
                        case 13:
                            MenuManager.f3(mlb);
                            break;
                        case 14:
                            MenuManager.f4(mlb);
                            break;
                        case 15:
                            MenuManager.f5(mlb);
                            break;
                    }
                    break;
            }
            
            switch (choice) {
                case 2:
                    int reader_choice = Mange_Menu.menuReader();
                    switch (reader_choice) {
                        case 1:
                            MenuManager.loadReaderFromFile(mlc);
                            break;
                        case 2:
                            MenuManager.addToEnd2(mlc);
                            break;
                        case 3:
                            MenuManager.displayReader(mlc);
                            break;
                        case 4:
                            MenuManager.saveToFile2(mlc);
                            break;
                        case 5:
                            MenuManager.searchByRCode(mlc);
                            break;
                        case 6:
                            MenuManager.deleteByRCode(mlc);
                            break;
                    }
                    break;
                case 0:
                    exit(0);
                    break;
            }
            
            switch (choice) {
                case 3:
                    int reader_choice = Mange_Menu.menuLender();
                    switch (reader_choice) {
                        case 1:
                            MenuManager.loadReaderFromFile(mlc);
                            break;
                        case 2:
                            MenuManager.addToEnd2(mlc);
                            break;
                        case 3:
                            MenuManager.displayReader(mlc);
                            break;
                        case 4:
                            MenuManager.saveToFile2(mlc);
                            break;
                    }
                    break;
                case 0:
                    exit(0);
                    break;
            }
        }
    }
}
