package interview.microsoft;

import java.util.Arrays;

public class MakeArrayDistinct {
    public static int minimumOperations(int[] A, int n) {

        int total = (A.length * (A.length + 1)) / 2;
        int currentTotal = Arrays.stream(A).sum();
        int minOperations = Math.abs(currentTotal - total);
        return minOperations > 1000000000 ? -1 : minOperations;
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 5, 6, 3};
        int n = a.length;

        System.out.println(minimumOperations(a, n));
    }
}
