
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Validate {

    private static Scanner sc = new Scanner(System.in);

    public static int getChoice(String msg, String err, int min, int max) {
        int a = 0;
        while (true) {
            try {
                System.out.print(msg);

                a = Integer.parseInt(sc.nextLine());
                if (a > 0) {
                    break;
                } else {
                    System.out.println("Choose > 0 !");
                }

            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }

        return a;
    }

    public static int getInt(String smg, String err) {
        int a = 0;
        while (true) {
            try {
                System.out.print(smg);

                a = Integer.parseInt(sc.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }

        return a;
    }

}
