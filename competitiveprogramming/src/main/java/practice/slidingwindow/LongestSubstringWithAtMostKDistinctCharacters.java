package practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int findLength(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = -1;

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() > k) {
                ans = Math.max(ans, j - i);
                while (map.size() > k) {
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

    public static int findLengthWithAtMostKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = -1;

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);


            while (map.size() > k) {
                char ci = s.charAt(i);
                map.put(ci, map.get(ci) - 1);
                if (map.get(ci) == 0) {
                    map.remove(ci);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLengthWithAtMostKDistinct("araaci", 10));
    }
}
