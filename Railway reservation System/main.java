/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guru
 */
import java.util.*;

public class main {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        admin ob = new admin();
        user ob2 = new user();
        int i = 1;
        while (i > 0) {
            System.out.println("***************************MAIN MENU********************");
            System.out.printf("1.admin mode\n2.user mode\n3.exit\nEnter the your choice\n");
            switch (s.nextInt()) {
                case 1:
                    int k = ob.main();
                    if (k == 0) {
                        break;
                    }
                case 2:
                    int c = ob2.main();
                    if (c == 0) {
                        break;
                    }
                case 3:
                    i = 0;
                    break;
                default:
                    System.out.println("please enter the correct option\n");
            }
            System.out.println();
        }
    }
}
