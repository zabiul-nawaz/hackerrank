package challenge.reducedstring;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

public class ReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        Stack<Character> stack = new Stack<Character>() {
            private static final long serialVersionUID = 1L;

            @Override
            public synchronized Character pop() {
                Character top = null;
                try {
                    top = super.pop();
                } catch (EmptyStackException e) {
                    //log warning
                }
                return top;
            }
        };
        s.chars().mapToObj(x -> new Character((char)x)).forEach(x -> {
            Character top = stack.pop();
            if(top == null) {
                stack.push(x);
            } else if(!top.equals(x)) {
                stack.push(top);
                stack.push(x);
            }
        });

        StringBuilder builder =  new StringBuilder();
        stack.stream().forEach(c -> builder.append(c));

        return Optional.of(builder).map( x-> x.toString()).filter(x -> !x.isEmpty()).orElse("Empty String");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(superReducedString("aab"));
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
         */}
}
