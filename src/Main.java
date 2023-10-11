import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //generate a list of list of character
        List<List<Character>> tableau = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {row.add((char) (3*i + j + '1'));}
            tableau.add(row);
        }
        //make a copy of the board called trigger, except all values are in the main list (will be used to check which case can be played)
        var trigger = tableau.stream().flatMap(List::stream).toList();
        //init some other variables
        boolean is_playing = true;
        short turn = 0;
        boolean player1won = false;
        boolean player2won = false;
        //main loop
        while (is_playing) {
            //todo
        }
    }
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
    public static String Input(String text) {
        //Print the text, ask the user an input, return the input
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        return sc.nextLine();
    }
    public static Character InputIn(String text, List<Character> values) {
        //get an input from the user, check if the input is in values, return the input if it is, else ask again
        String input = Input(text);
        while (!values.contains(input.charAt(0))) {
            input = Input(text);
        }
        return input.charAt(0);
    }
}