import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static boolean is_playing = true;
    static short turn = 0;
    static boolean player1won = false;
    static boolean player2won = false;
    public static void main(String[] args) {
        //generate a list of list of character
        List<List<Character>> tableau = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {row.add((char) (3*i + j + '1'));}
            tableau.add(row);
        }
        //make a copy of the board called trigger, except all values are in the main list (will be used to check which case can be played)
        var trigger = tableau.stream().flatMap(List::stream).collect(Collectors.toList());
        //init some other variables
        //main loop
        while (is_playing) {
            //print the board and ask the player to play
            clear();
            System.out.println(getBoard(tableau));
            var played = inputIn("Player " + (turn % 2 + 1) + " turn: ", trigger);
            //remove the value played from the trigger list so it can't be played again
            trigger.remove(played);
            //update the board
            var row = (played - '1') / 3;
            var col = (played - '1') % 3;
            tableau.get(row).set(col, (turn % 2 == 0) ? 'X' : 'O');
            //check if the player won
            end(tableau);
            //update some variables
            turn++;
            if (turn == 9) {is_playing = false;}
        }
        clear();
        System.out.println(getBoard(tableau));
        System.out.println();
        if (player1won) {System.out.println("Player 1 won");}
        else if (player2won) {System.out.println("Player 2 won");}
        else {System.out.println("Tie, nobody won");}
    }
    public static void clear() {
        //clear the shell
        for (int i = 0; i<50; i++) {System.out.println();}
    }
    public static String getBoard(List<List<Character>> tableau) {
    /*  X|X|X
        -+-+-
        X|X|X
        -+-+-
        X|X|X   */
        return tableau.stream()
                .map(row -> row.stream()
                        .map(String::valueOf)
                        .reduce("", (a, b) -> a + "|" + b)
                        .substring(1))
                .reduce("", (a, b) -> a + "\n-+-+-\n" + b)
                .substring("\n-+-+-\n".length());
    }
    public static String input(String text) {
        //Print the text, ask the user an input, return the input
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        return sc.nextLine();
    }
    public static Character inputIn(String text, List<Character> values) {
        //get an input from the user, check if the input is in values, return the input if it is, else ask again
        String input;
        do {input = input(text);} while (Objects.equals(input, "") || !values.contains(input.charAt(0)));
        return input.charAt(0);
    }
    private static void end(List<List<Character>> tableau) {
        for (int i=0; i<3; i++) {
            if (tableau.get(i).get(0) == tableau.get(i).get(1) && tableau.get(i).get(1) == tableau.get(i).get(2)) {win(tableau.get(i).get(1));}
            if (tableau.get(0).get(i) == tableau.get(1).get(i) && tableau.get(1).get(i) == tableau.get(2).get(i)) {win(tableau.get(1).get(i));}
            if (
                (tableau.get(1).get(1) == tableau.get(0).get(0) && tableau.get(1).get(1) == tableau.get(2).get(2)) ||
                (tableau.get(1).get(2) == tableau.get(0).get(0) && tableau.get(1).get(1) == tableau.get(2).get(1))
            ) {win(tableau.get(1).get(1));}
        }
    }
    private static void win(char value) {
        switch (value) {
            case 'X' -> player1won = true;
            case 'O' -> player2won = true;
        }
        is_playing = false;
    }
}