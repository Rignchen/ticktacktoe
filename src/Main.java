import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        var trigger = tableau.stream().flatMap(List::stream).collect(Collectors.toList());
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
    public static void clear() {
        //clear the shell
        try {Runtime.getRuntime().exec("clear");}
        catch (Exception e) {e.printStackTrace();}
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
                .substring(1);
    }
    public static String input(String text) {
        //Print the text, ask the user an input, return the input
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        return sc.nextLine();
    }
    public static Character inputIn(String text, List<Character> values) {
        //get an input from the user, check if the input is in values, return the input if it is, else ask again
        String input = input(text);
        while (!values.contains(input.charAt(0))) {
            input = input(text);
        }
        return input.charAt(0);
    }
}