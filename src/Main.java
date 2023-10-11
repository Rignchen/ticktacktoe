import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {System.out.println("Hello World!");}
    public static void printBoard(List<List<Character>> tableau) {
    /*  X|X|X
        -+-+-
        X|X|X
        -+-+-
        X|X|X   */
        for (int i = 0; i < tableau.size(); i++) {
            for (int j = 0; j < tableau.get(i).size(); j++) {
                System.out.print(tableau.get(i).get(j));
                if (j < tableau.get(i).size() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < tableau.size() - 1) {
                for (int j = 0; j < tableau.get(i).size(); j++) {
                    System.out.print("-");
                    if (j < tableau.get(i).size() - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}