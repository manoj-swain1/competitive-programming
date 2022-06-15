package practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicallySmallesPermutationWithIndicesSwap {


    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 2,1};
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(0, 1));
        pairs.add(new Pair(2, 3));
        pairs.add(new Pair(0, 3));
        pairs.add(new Pair(0, 4));
        Collections.sort(pairs, Comparator.comparingInt(o -> o.i));
        findSmallestPermutation(arr, pairs);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void findSmallestPermutation(int[] arr, List<Pair> pairs) {

        while (true) {
            boolean found = true;
            for (Pair pair : pairs) {
                int m = pair.i;
                int n = pair.j;

                if (arr[n] < arr[m]) {
                    int temp = arr[m];
                    arr[m] = arr[n];
                    arr[n] = temp;
                    found = false;
                }
            }
            if (found) {
                break;
            }
        }


    }
}

class Pair implements Comparable<Pair> {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair o) {
        return this.i = o.i;
    }
}
