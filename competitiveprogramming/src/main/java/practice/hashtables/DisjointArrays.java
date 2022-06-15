package practice.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DisjointArrays {
    public static Object isDisjoint(int[] arr1,int[] arr2) {

        Set<Integer> set=new HashSet<>();
        Arrays.stream(arr1).forEach(set::add);
        return Arrays.stream(arr2).noneMatch(set::contains);
    }
}
