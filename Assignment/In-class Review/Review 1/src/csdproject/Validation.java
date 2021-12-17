package csdproject;

import java.util.Scanner;

public class Validation {
    Scanner in = new Scanner(System.in);

    boolean bCodeExisted(MyList<Book> b, String bCode){
        Node<Book> cu = b.head;
        while(cu != null){
            if (cu.data.bcode.equals(bCode)){
                return true;
            }cu = cu.next;
        }
        return false;
    }

    boolean rCodeExisted(MyList<Reader> r, String rCode){
        Node<Reader> cu = r.head;
        while(cu != null){
            if (cu.data.rcode.equals(rCode)) return true;
            cu = cu.next;
        }return false;
    }

    boolean lCodeExisted(MyList<Lending> l, String lCode){
        Node<Lending> cu = l.head;
        while(cu != null){
            if (cu.data.rcode.equals(lCode)) return true;
            cu = cu.next;
        }return false;
    }

    int inputIntLimit(int min, int max){
        while(true){
            int result = Integer.parseInt(in.nextLine());
            if (result < min || result > max){
                System.out.print("Enter again: ");
            }else{
                return result;
            }
        }
    }

    double doubleInput(){
        while(true){
            double input = Double.parseDouble(in.nextLine());
            return input;
        }
    }

    String inputString(){
        while(true){
            String result = in.nextLine();
            if (result.isEmpty()){
                System.out.print("Enter again: ");
            }else return result;
        }
    }
}
