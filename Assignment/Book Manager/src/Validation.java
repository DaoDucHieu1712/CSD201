
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
public class Validation {

    Scanner sc = new Scanner(System.in);

    

    String getString(String msg, String err, String regex) {
        while (true) {
            System.out.print(msg);
            String line = sc.nextLine().trim();
            if (line.matches(regex)) {
                return line;
            } else {
                System.err.println(err);
            }
        }
    }

    int getDouble(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.err.println(err);
                }
                return num;
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    int getInt_2(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.err.println(err);
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < min || num > max) {
                    System.err.println(err);
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }
}
