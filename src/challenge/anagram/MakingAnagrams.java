package challenge.anagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        IntStream firstPart = s1.chars();
        StringBuffer secondPart = new StringBuffer(s2);
        return (int) firstPart.filter(i
                -> {
                    int index = secondPart.indexOf(String.valueOf((char)i));
                    if(index == -1) {
                        return true;
                    }
                    secondPart.deleteCharAt(index);
                    return false;
                }).count() + secondPart.length();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(makingAnagrams("cde", "abc"));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
