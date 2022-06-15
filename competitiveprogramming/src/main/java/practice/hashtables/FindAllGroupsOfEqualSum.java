package practice.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllGroupsOfEqualSum {

    public List<Pair> findAllPairsEqualSum(int[] arr) {
        List<Pair> ans = new ArrayList<>();
        Map<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    Pair pair1 = map.get(sum);
                    Pair pair2 = new Pair(arr[i], arr[j]);
                    ans.add(pair1);
                    ans.add(pair2);
                } else {
                    map.put(sum, new Pair(arr[i], arr[j]));
                }
            }
        }

        return ans;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
