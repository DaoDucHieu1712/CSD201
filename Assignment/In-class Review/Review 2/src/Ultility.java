

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import static java.util.Collections.list;

public class Ultility {
    Validation valid = new Validation();
    MyList<Reader> lr = new MyList<>();
    MyList<Book> lb = new MyList<>();
    MyList<Lending> ll = new MyList<>();
    BufferedReader br;
    BufferedWriter bw;

    void bookMenu() throws Exception{
        while(true){
            System.out.print(
                    "1.  f1\n" +
                    "2.  f2\n" +
                    "3.  f3\n" +
                    "4.  f4\n" +
                    "5.  f5\n" +
                    "6.  Exit" +
                    "\nYour choice: ");
            int choice = valid.inputIntLimit(1, 6);
            switch(choice){
                case 1:
                    lb.clear();
                    readBookFileAndView();
                    break;
                case 2:
                    lb.clear();
                    readBookFile();
                    Node <Book> b = searchBCode("3");
                    b.data.setQuantity(9);
                    lb.display();
                    break;
                case 3:
                    lb.addLast(new Book("6", "G", 2, 1, 1));
                    lb.display();
                    break;
                case 4:
                    lb.clear();
                    readBookFile();
                    Node <Book> fb = searchBCode("1");
                    lb.delete(fb);
                    lb.display();
                    break;
                case 5:
                    lb.clear();
                    readBookFile();
                    sortByLended();
                    lb.display();
                    break;
                case 6:
                    return;
            }
        }
    }

    void readerMenu() throws Exception {
        while(true){
            System.out.print("1.      Load data from file\n" +
                    "2.      Input & add to the end\n" +
                    "3.      Display data\n" +
                    "4.      Save reader list to file\n" +
                    "5.      Search by rcode\n" +
                    "6.      Delete by rcode" + "\n7.     Exit" +"\nYour choice: ");
            int choice = valid.inputIntLimit(1, 7);
            switch(choice){
                case 1:
                    loadReaderList();
                    break;
                case 2:
                    inputReader();
                    break;
                case 3:
                    lr.display();
                    break;
                case 4:
                    saveReaderList();
                    break;
                case 5:
                    System.out.print("Enter reader's code to search: ");
                    String code = valid.inputString();
                    Node <Reader> fr = searchRCode(code);
                    if (fr == null) System.out.println("Not found");
                    else System.out.println("Found");
                    break;
                case 6:
                    System.out.print("Enter reader's code to search: ");
                    String rCode = valid.inputString();
                    Node <Reader> f = searchRCode(rCode);
                    if (f == null) System.out.println("Not found");
                    else lr.delete(f);
                    break;
                case 7:
                    return;
            }
        }
    }

    void lendingMenu(){
        while(true){
            System.out.print("1.      Input data\n" +
                    "2.      Display data\n" +
                    "3.      Sort  by bcode + rcode\n4.     Exit \nYour choice: ");
            int choice = valid.inputIntLimit(1, 4);
            switch(choice){
                case 1:
                    inputLending();
                    break;
                case 2:
                    ll.display();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    return;
            }
        }
    }

    void saveBookFile() throws Exception{
        System.out.print("Enter filename to save: ");
        String fileName = valid.inputString();
        bw = new BufferedWriter(new FileWriter(fileName, false));
        Node <Book> cu = lb.head;
        while(cu != null){
            bw.append(cu.data.toString()+"\n");
            cu = cu.next;
        }
        bw.close();
    }

    void readBookFile() throws Exception{
        System.out.print("Enter filename: ");
        String filename = valid.inputString();
        String cur;
        br = new BufferedReader(new FileReader(filename));
        while ((cur = br.readLine()) != null){
            String[] book = cur.split("\\|");
           if (book.length == 4){
               String bCode = book[0].trim();
               String name = book[1].trim();
               int quantity = Integer.parseInt(book[2].trim());
               double price = Double.parseDouble(book[3].trim());
               lb.addLast(new Book(bCode, name, quantity, 0, price));
           }else if (book.length == 5){
               String bCode = book[0].trim();
               String name = book[1].trim();
               int quantity = Integer.parseInt(book[2].trim());
               int lended = Integer.parseInt(book[3].trim());
               double price = Double.parseDouble(book[4].trim());
               lb.addLast(new Book(bCode, name, quantity, lended, price));
           }
        }
        br.close();
    }

    void readBookFileAndView() throws Exception{
        System.out.print("Enter filename: ");
        String filename = valid.inputString();
        String cur;
        br = new BufferedReader(new FileReader(filename));
        while ((cur = br.readLine()) != null){
            String[] book = cur.split("\\|");
            if (book.length == 4){
                String bCode = book[0].trim();
                String name = book[1].trim();
                int quantity = Integer.parseInt(book[2].trim());
                double price = Double.parseDouble(book[3].trim());
                lb.addLast(new Book(bCode, name, quantity, 0, price));
            }else if (book.length == 5){
                String bCode = book[0].trim();
                String name = book[1].trim();
                int quantity = Integer.parseInt(book[2].trim());
                int lended = Integer.parseInt(book[3].trim());
                double price = Double.parseDouble(book[4].trim());
                lb.addLast(new Book(bCode, name, quantity, lended, price));
            }
        }
        br.close();
        System.out.println("code | Title | Quantity | Lended | Price | Value\n" +
                "-------------------------------------------------------------------");
        Node<Book> cu = lb.head;
        while(cu != null){
            System.out.println(cu.data.toString() + " \t " + cu.data.price * cu.data.quantity);
            cu = cu.next;
        }
    }

    Book inputBook(){
        while(true){
            System.out.print("Enter book's code: ");
            String code = valid.inputString();
            if (searchBCode(code) != null) continue;
            System.out.print("Enter book's title: ");
            String title = valid.inputString();
            System.out.print("Enter quantity: ");
            int quantity = valid.inputIntLimit(1, 999999999);
            System.out.print("Enter lend: ");
            int lend = valid.inputIntLimit(0, quantity);
            System.out.print("Enter price: ");
            double price = valid.doubleInput();
            return new Book(code, title, quantity, lend, price);
        }
    }

    Node <Book> searchBCode(String xCode){
        Node <Book> cu = lb.head;
        while(cu != null){
            if (cu.data.bcode.equalsIgnoreCase(xCode)) return cu;
            cu = cu.next;
        }return null;
    }

    void sortByBCode(){
        Node <Book> cu = lb.head;
        while(cu != null){
            Node<Book> n1 = cu;
            Node<Book> n2 = cu.next;
            while(n2 != null){
                if (n2.data.bcode.compareTo(n1.data.bcode) < 0){
                    n1 = n2;
                }
                n2 = n2.next;
            }
            Book temp = cu.data;
            cu.data = n1.data;
            n1.data = temp;
            cu = cu.next;
        }
    }

    void sortByQuantity(){
        Node <Book> cu = lb.head;
        while(cu != null){
            Node<Book> n1 = cu;
            Node<Book> n2 = cu.next;
            while(n2 != null){
                if (n2.data.quantity < n1.data.quantity){
                    n1 = n2;
                }
                n2 = n2.next;
            }
            Book temp = cu.data;
            cu.data = n1.data;
            n1.data = temp;
            cu = cu.next;
        }
    }
    
    void sortByLended(){
        Node <Book> cu = lb.head;
        while(cu != null){
            Node<Book> n1 = cu;
            Node<Book> n2 = cu.next;
            while(n2 != null){
                if (n2.data.lended < n1.data.lended){
                    n1 = n2;
                }
                n2 = n2.next;
            }
            Book temp = cu.data;
            cu.data = n1.data;
            n1.data = temp;
            cu = cu.next;
        }
    }

    void loadReaderList() throws Exception{
        System.out.print("Enter filename to load: ");
        String filename = valid.inputString();
        br = new BufferedReader(new FileReader(filename));
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split("\\|");
            String rCode = data[0].trim();
            String name = data[1].trim();
            int bYear = Integer.parseInt(data[2].trim());
            if (bYear >= 1900 && bYear <= 2010){
                lr.addLast(new Reader(rCode, name, bYear));
            }
        }
        br.close();
    }

    void saveReaderList() throws Exception{
        System.out.print("Enter filename to save: ");
        String fileName = valid.inputString();
        bw = new BufferedWriter(new FileWriter(fileName, false));
        Node <Reader> cu = lr.head;
        while(cu != null){
            bw.append(cu.data.toString());
            cu = cu.next;
        }
        bw.close();
    }

    Node <Reader> searchRCode(String xCode){
        Node <Reader> cu = lr.head;
        while(cu != null){
            if (cu.data.rcode.equalsIgnoreCase(xCode)) return cu;
            cu = cu.next;
        }return null;
    }

    void inputReader(){
        while(true){
            System.out.print("Enter reader's code: ");
            String code = valid.inputString();
            if (searchRCode(code) != null) continue;
            System.out.print("Enter reader's name: ");
            String name = valid.inputString();
            System.out.print("Enter birth-year: ");
            int bYear = valid.inputIntLimit(1900, 2010);
            lr.addLast(new Reader(code, name, bYear));
        }
    }

    void inputLending(){
        while(true){
            System.out.print("Enter book's code: ");
            String bCode = valid.inputString();
            System.out.print("Enter reader's code: ");
            String rCode = valid.inputString();
            System.out.print("Enter state: ");
            int state = valid.inputIntLimit(0, 2);
            Node <Book> b = searchBCode(bCode);
            Node <Reader> r = searchRCode(rCode);
            if (b == null || r == null){
                System.out.println("Not accepted");
            }else if (b == null && r == null && state == 1){
                System.out.println("Not accepted");
            }else if (b != null && r != null && b.data.lended == b.data.quantity){
                ll.addLast(new Lending(bCode, rCode, 0));
                b.data.lended++;
                b.data.quantity--;
                break;
            }else if (b != null && r != null && b.data.lended < b.data.quantity){
                ll.addLast(new Lending(bCode, rCode, 1));
                b.data.lended++;
                b.data.quantity--;
                break;
            }
        }
    }

    public int compareLending(Lending o1, Lending o2) {
        if (o1.bcode.equalsIgnoreCase(o2.bcode)){
            return o1.rcode.compareTo(o2.rcode);
        }else{
            return o1.bcode.compareTo(o2.bcode);
        }
    }

    void sort(){
        Node <Lending> cu = ll.head;
        while(cu != null){
            Node<Lending> n1 = cu;
            Node<Lending> n2 = cu.next;
            while(n2 != null){
                if (compareLending(n1.data, n2.data) > 0){
                    n1 = n2;
                }
                n2 = n2.next;
            }
            Lending temp = cu.data;
            cu.data = n1.data;
            n1.data = temp;
            cu = cu.next;
        }
    }
}
