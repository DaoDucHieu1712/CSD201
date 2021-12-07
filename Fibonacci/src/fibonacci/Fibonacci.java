/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author ADMIN
 */
public class Fibonacci {

    static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    static void generateListFibonacci() {
        int n = Validate.getInt("Enter n :", "Invalid !");
        System.out.println("List Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(Fibonacci(i) + " ");
        }
        System.out.println("");
    }
    
    
    static void findFibonacci() {
        int n = Validate.getInt("Enter n :", "Invalid !");
        System.out.println("Fibonacci : " + Fibonacci(n));
    }

    public static void main(String[] args) {
        while (true) {            
            System.out.println("1.Find Fibonacci");
            System.out.println("2.Generate List Fibonacci");
            System.out.println("3.Exit");
            int choice = Validate.getChoice("Choice: ", "Invalid !", 1, 3);
            switch(choice){
                case 1:
                    findFibonacci();
                    System.out.println("");
                    break;
                case 2:
                    generateListFibonacci();
                    System.out.println("");
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
