package practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAllDistinctCharacters {

    public static int findLength(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = -1;

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (j - i + 1 == map.size()) {
                ans = Math.max(ans, j - i + 1);
            } else if (j - i + 1 > map.size()) {

                while (j - i + 1 > map.size()) {
                    char ci = s.charAt(i);
                    map.put(ci, map.get(ci) - 1);
                    if (map.get(ci) == 0) {
                        map.remove(ci);
                    }
                    i++;
                }
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
    }
}
