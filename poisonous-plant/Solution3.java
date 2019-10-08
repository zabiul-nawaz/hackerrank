import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

    static int poisonousPlants(int[] p) {
        int dayCount = 0;
        class Plant {
            public int pesticide;
            Plant(int pesticide) {
                this.pesticide = pesticide;
            }
        }
        LinkedList<Plant> list = new LinkedList<Plant>();
        for(int i:p) {
            list.add(new Plant(i));
        }
        while(true) {
            LinkedList<Plant> newList = new LinkedList<Plant>();
            newList.add(list.get(0));
            for(int i = 0; i < list.size() - 1; i++) {
                Plant left = list.get(i);
                Plant right = list.get(i+1);

                if(left.pesticide >= right.pesticide) {
                    newList.add(right);
                }
            }
            if(newList.size() == list.size()) {
                break;
            }
            list = newList;
            dayCount++;
        }
        return dayCount;
    }

    static int poisonousPlants2(int[] p) {
        int dayCount = 0;
        class Plant {
            public int pesticide;
            Plant(int pesticide) {
                this.pesticide = pesticide;
            }
        }
        LinkedList<Plant> list = new LinkedList<Plant>();
        for(int i:p) {
            list.add(new Plant(i));
        }
        while(true) {
            List<Plant> removalList = new ArrayList<Plant>();
            for(int i = 0; i < list.size() - 1; i++) {
                Plant left = list.get(i);
                Plant right = list.get(i+1);

                if(left.pesticide < right.pesticide) {
                    removalList.add(right);
                }
            }
            if(removalList.isEmpty()) {
                break;
            }
            list.removeAll(removalList);
            dayCount++;
        }
        return dayCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }*/
        int p[] = {3, 6, 2, 7, 5};
        System.out.println(poisonousPlants(p));

        int q[] = {6, 5, 8, 4, 7, 10, 9};
        System.out.println(poisonousPlants(q));

        int r[] = {8, 1, 6, 7, 5, 4, 5, 2, 8};
        System.out.println(poisonousPlants(r));



        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
