
import java.util.Scanner;

public class main {

    void display(char c[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c[i][j] == '\0') {
                    System.out.print("   |");
                } else {
                    System.out.print(" " + c[i][j] + " |");
                }
            }
            System.out.println();
            System.out.println("------------");

        }
    }

    boolean result(boolean a, char c, int l) {
        if (a == true && c == 'X') {
            System.out.println("Player X wins the game");
            return true;
        } else if (a == true && c == 'O') {
            System.out.println("Player Y wins the match");
            return true;
        } else if (a == false && l == 8) {
            System.out.println("game over draw");
            return true;
        }
        return false;
    }

    boolean checkWins(char c[][]) {

        //we done also using row,column,diagnol,anti-diagnol wise using for loop but it will not efficiency
        //for optimal solution i use multiple if statement
        if (c[0][1] != '\0' && c[0][1] == c[0][2] && c[0][1] == c[0][0]) {
            return true;
        } else if (c[1][0] != '\0' && c[1][0] == c[0][0] && c[2][0] == c[1][0]) {
            return true;
        } else if (c[1][1] != '\0' && c[1][1] == c[1][0] && c[1][1] == c[1][2] || c[1][1] != '\0' && c[1][1] == c[0][1] && c[1][1] == c[2][1]) {
            return true;
        } else if (c[1][2] != '\0' && c[1][2] == c[0][2] && c[1][2] == c[2][2]) {
            return true;
        } else if (c[2][1] != '\0' && c[2][1] == c[2][0] && c[2][1] == c[2][2]) {
            return true;
        } else if (c[0][0] != '\0' && c[0][0] == c[1][1] && c[2][2] == c[1][1] || c[0][2] != '\0' && c[0][2] == c[1][1] && c[2][0] == c[1][1]) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        char c[][] = new char[3][3];
        main ob = new main();
        boolean a = false;
        int l = 0, i, j;
        while (l < 9) { // TO GET N VALUES
            while (true) {  //TO CHECK THE BOX IS ALREADY FILLED
                if (l % 2 == 0) {
                    System.out.println("player X: pls,enter the row and column");
                    i = s.nextInt();
                    j = s.nextInt();
                    if (c[i][j] == '\0') {
                        c[i][j] = 'X';
                        break;
                    } else {
                        System.out.println("already filled pls enter new one:");
                        continue;
                    }
                } else {
                    System.out.println("player Y: pls,enter the row and column");
                    i = s.nextInt();
                    j = s.nextInt();
                    if (c[i][j] == '\0') {
                        c[i][j] = 'O';
                        break;
                    } else {
                        System.out.println("already filled pls enter new one:");
                        continue;
                    }
                }
            }
            ob.display(c);
            a = ob.checkWins(c);
            a = ob.result(a, c[i][j], l);
            if (a) {
                break;
            }
            l++;
        }

    }
}
