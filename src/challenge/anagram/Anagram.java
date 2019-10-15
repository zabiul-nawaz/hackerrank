package challenge.anagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length() == 0 || s.length()%2 != 0) {
            return -1;
        }
        IntStream firstPart = s.substring(0, s.length()/2).chars();

        StringBuffer secondPart = new StringBuffer(s.substring(s.length()/2));
        return (int) firstPart.filter(i
                -> {
                    int index = secondPart.indexOf(String.valueOf((char)i));
                    if(index == -1) {
                        return true;
                    }
                    secondPart.deleteCharAt(index);
                    return false;
                }).count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println(anagram("aaabbb"));
        System.out.println(anagram("ab"));
        System.out.println(anagram("abc"));
        System.out.println(anagram("mnop"));
        System.out.println(anagram("xyyx"));
        System.out.println(anagram("xaxbbbxx"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
