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

public class user {

    String name[][] = new String[72][2];

    HashMap<Integer, Integer> ar = new HashMap<Integer, Integer>();
    String seat[] = {"", "window", "middle", "aisle"};

    boolean avail(int kk) {

        Scanner s = new Scanner(System.in);
        int c = 0;
        for (int j = 1; j <= kk; j++) {
            String sss[] = new String[3];
            System.out.println("Enter the seat number 1-72");
            int a = s.nextInt();
            int i = 0;
            if (a % 6 == 0 || a % 6 == 1) {
                i = 1;
            } else if (a % 6 == 2 || a % 6 == 5) {
                i = 2;
            } else {
                i = 3;
            }

            if (ar.containsKey(a)) {
                System.out.println("seat no: " + a + " is already booked");
                System.out.println("please enter another seat number");
                avail(kk - j + 1);
            } else {
                c++;
                System.out.println("seat no : " + a + " is availabe");
                System.out.println("seat :" + seat[i]);
                System.out.println("Enter the pass name " + j);
                name[a][0] = s.next();
                s.nextLine();
                System.out.println("enter age of pass:");
                name[a][1] = s.nextLine();
                ar.put(a, 1);
            }
        }
        return true;

    }

    void reserve() {
        Scanner s = new Scanner(System.in);
        System.out.println("------------------------WELCOME TO RESERVATION DESK---------------------");
        System.out.printf("Enter 1 for booking\n 2.for user menu\n");
        int ll = s.nextInt();
        while (true) {
            if (ll == 1) {
                System.out.println("seats availability:" + (72 - ar.size()));
                System.out.println("Enter the number of seats required");
                int a = s.nextInt();
                if (a <= (72 - ar.size())) {
                    boolean nnn = avail(a);
                    if (nnn == true) {
                        System.out.println("successfully booked");
                        System.out.println("--------------------------------------------------------");
                        break;
                    } else {
                        System.out.println("sorry only" + (72 - ar.size()) + " seats are available");
                        System.out.println("--------------------------------------------------------");
                        reserve();
                    }
                }
            }
        }
    }

    void cancel() {

        Scanner s = new Scanner(System.in);
        System.out.println("enter the seat number");
        int ss = s.nextInt();
        System.out.println("enter the passanger name");
        String pp = s.next();
        s.nextLine();
        if (ar.containsKey(ss) && name[ss][0].equals(pp)) {
            System.out.printf("ARE YOU SURELY WANT TO CANCEL--\n1.YES\n2.NO\n");
            if (s.nextInt() == 1) {
                ar.remove(ss);
                name[ss][0] = "";
                name[ss][1] = "";
                System.out.println("cancelled sussess");
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("sorry back to menu..");
        }

    }

    void status() {
        System.out.println((72 - ar.size() + "seats are available"));
    }

    int main() {
        Scanner s = new Scanner(System.in);
        password ob = new password();
        int i = 1;
        while (i > 0) {
            String k = "";
            String v = "";
            System.out.println("------welcome to user menu--------");
            System.out.println("ENTER YOUR USER NAME:");
            k = s.next();
            s.nextLine();
            System.out.println("ENTER YOUR PASSWORD");
            v = s.nextLine();
            boolean tf = ob.password(k, v);
            while (tf) {
                System.out.printf("1.reserve\n2.cancel\n3.status\n4.main menu\n");
                switch (s.nextInt()) {
                    case 1:
                        reserve();
                        break;
                    case 2:
                        cancel();
                        break;
                    case 3:
                        status();
                        break;
                    case 4:
                        return 0;
                    default:
                        System.out.println("pls choose correct option");
                }
            }
            int a = 0;
            if (!tf) {
                System.out.printf("please enter 1 to correct password\n or enter 2 to main menu\n");
                a = s.nextInt();
            }
            if (a != 1) {
                //return 0;
                break;
            }
        }
        return 0;
    }
}
