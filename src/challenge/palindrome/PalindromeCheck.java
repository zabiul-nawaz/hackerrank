package challenge.palindrome;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalindromeCheck {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        java.util.stream.IntStream firstPart = s.chars();
        Set<Character> set = new HashSet<>();
        firstPart.forEach(i
                -> {
                    if(!set.remove((char)i)) {
                        set.add((char)i);
                    }
                });
        return set.size() > 1 ? "NO" : "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {



        System.out.println(gameOfThrones("aaabbbb"));

        System.out.println(gameOfThrones("cdefghmnopqrstuvw"));

        System.out.println(gameOfThrones("cdcdcdcdeeeef"));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
