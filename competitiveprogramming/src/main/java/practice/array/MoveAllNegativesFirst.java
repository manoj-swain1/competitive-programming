package practice.array;

import java.util.Arrays;

public class MoveAllNegativesFirst {

    public static void moveNegatives(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, -10, -1, 5,7,-2};
        moveNegatives(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
