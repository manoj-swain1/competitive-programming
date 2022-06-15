package practice.hashtables;

import java.util.HashMap;

public class FindSymmetric {
    public static String findSymmetric(int[][] arr) {

        String result = "";

        var pairs = new HashMap<Integer, Integer>();
        for (int[] pair : arr) {
            if (pairs.containsKey(pair[1])) {
                var val = pairs.get(pair[1]);
                if (val == pair[0]) {
                    result = result.concat(appendPairs(pair[1], pair[0]));
                }
            }
            pairs.put(pair[0], pair[1]);
        }
        return result;
    }

    private static String appendPairs(int v1,int v2) {
        var commaSep = String.join(",", v1 + "", v2 + "");
        return String.join("", "{", commaSep, "}");
    }
}
