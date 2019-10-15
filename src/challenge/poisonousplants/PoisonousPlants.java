package challenge.poisonousplants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PoisonousPlants {

    static int poisonousPlants(int[] p) {
        class PlantNode {
            PlantNode factorNode;
            Integer nodeValue;
            Integer life;

            public PlantNode(Integer nodeValue, Integer life, PlantNode factorNode) {
                this.factorNode = factorNode;
                this.nodeValue = nodeValue;
                this.life = life;
            }
        }
        final PlantNode[] lastNode = new PlantNode[1];

        PlantNode firstNode = new PlantNode(p[0], -1, null);
        lastNode[0] = firstNode;

        Optional<Integer> optMaxDays = Arrays.stream(p).boxed().skip(1).map(x -> {
            int maxLife = 0;
            PlantNode factorNode = null;
            PlantNode prevNode = lastNode[0];
            while(prevNode != null) {
                if(prevNode.nodeValue < x) {
                    factorNode = prevNode;
                    break;
                }
                maxLife = maxLife > prevNode.life ? maxLife : prevNode.life;
                prevNode = prevNode.factorNode;
            }
            if(factorNode == null) {
                maxLife = -1;
            }

            PlantNode node = new PlantNode(x, ++maxLife, factorNode);
            lastNode[0] = node;
            return node.life;
        }).max(Comparator.naturalOrder());


        return optMaxDays.get();
    }

    //    static class PlantNode {
    //        PlantNode factorNode;
    //        Integer nodeValue;
    //        Integer life;
    //
    //        public PlantNode(Integer nodeValue, Integer life, PlantNode factorNode) {
    //            this.factorNode = factorNode;
    //            this.nodeValue = nodeValue;
    //            this.life = life;
    //        }
    //    }

    //    static int poisonousPlants3(int[] p) {
    //        LinkedList<PlantNode> list = new LinkedList<>();
    //        final PlantNode[] lastNode = new PlantNode[1];
    //        PlantNode firstNode = new PlantNode(p[0], -1, null);
    //        lastNode[0] = firstNode;
    //        Optional<Integer> optMaxDays = Arrays.stream(p).boxed().skip(1).map(x -> {
    //            PlantNode node = calculateNode(x, lastNode[0]);
    //            lastNode[0] = node;
    //            return node.life;
    //        }).max(Comparator.naturalOrder());
    //
    //
    //        return optMaxDays.get();
    //    }

    //    private static PlantNode calculateNode(Integer nodeValue, PlantNode prevNode) {
    //        int maxLife = 0;
    //        PlantNode factorNode = null;
    //        while(prevNode != null) {
    //            factorNode = prevNode;
    //            if(prevNode.nodeValue < nodeValue) {
    //                break;
    //            }
    //            maxLife = maxLife > prevNode.life ? maxLife : prevNode.life;
    //            prevNode = prevNode.factorNode;
    //        }
    //
    //        return new PlantNode(nodeValue, ++maxLife, factorNode);
    //    }



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
        int p[] = {3, 6, 2, 7, 5}; // 2
        System.out.println(poisonousPlants(p));

        int q[] = {6, 5, 8, 4, 7, 10, 9};//2
        System.out.println(poisonousPlants(q));

        int r[] = {8, 1, 6, 7, 5, 4, 5, 2, 8}; //4
        System.out.println(poisonousPlants(r));

        int s[] = {4, 3, 7, 5, 6, 4, 2};//3
        System.out.println(poisonousPlants(s));



        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }

    static int poisonousPlant1(int[] p) {
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
}
