import java.io.IOException;
import java.util.Scanner;

public class MakingCandles {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
        long minPasses = 1;
        long res = 0;
        long bal = 0;
        double midVal = 0;
        while(true) {
            if(m*w >= n) {
                break;
            }
            res = (m * w + bal) / p;
            bal = (m * w + bal) - res*p;
            midVal = (m + w + res) / 2.0;
            if(midVal >= w && midVal >= m) {
                m = (long) Math.ceil((m + w + res) / 2.0);
                w = (long) Math.floor((m + w + res) / 2.0);
            } else if (midVal < m){
                w = w + res;
            } else {
                m = m + res;
            }

            minPasses++;
        }
        return minPasses;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/

        System.out.println(minimumPasses(3, 1, 2, 12));
    }
}
