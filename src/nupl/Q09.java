package nupl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q09 {

    private static List<Integer> starting;
    private static List<Integer> ending;

    public static void main(String[] args) {
        starting = new LinkedList<>(Arrays.asList(1, 3, 5, 8, 8));
        ending = new LinkedList<>(Arrays.asList(2, 5, 9, 10, 10));

        filterList();

        int size = starting.size();
        int validPairCount = 0;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (ending.get(i) < starting.get(j)
                    || starting.get(i) > ending.get(j)) {
                    validPairCount += 1;
                    System.out.println((i + 1) + " & " + (j + 1));
                }
            }
        }

        System.out.println("Total: " + validPairCount);
    }

    private static void filterList() {
        int size = starting.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (starting.get(i) == starting.get(j)
                    && ending.get(i) == ending.get(j)) {
                    starting.remove(i);
                    ending.remove(j);
                }
            }
        }
    }
}
