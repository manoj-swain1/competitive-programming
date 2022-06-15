package practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    public static int findLength(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = -1;

        while (j < arr.length) {
            char c = arr[j];
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == 2) {
                ans = Math.max(ans, j - i + 1);
            }
            while (map.size() > 2) {
                char ci = arr[i];
                map.put(ci, map.get(ci) - 1);
                if (map.get(ci) == 0) {
                    map.remove(ci);
                }
                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLength(arr));
    }
}
