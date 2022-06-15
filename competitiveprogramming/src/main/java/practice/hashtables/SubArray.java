package practice.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArray {
    public static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        Arrays.stream(arr1).forEach(set::add);
        return Arrays.stream(arr2).allMatch(set::contains);
    }

    public static void main(String[] args) {
        int[] arr1={5,-7,2,9,0};
        int[] arr2={9,2};
        System.out.println(isSubset(arr1,arr2));
    }
}
