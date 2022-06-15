package practice.hashtables;

import java.util.HashMap;
import java.util.Map;

public class TraceCompletePath {
    public static String tracePath(Map<String, String> map) {
        StringBuilder completePath = new StringBuilder();

        Map<String, String> reversedMap = new HashMap<>();

        map.forEach((key, value) -> reversedMap.put(value, key));
        int count = 0;
        String from = "";
        for (Map.Entry<String, String> e : map.entrySet()) {
            if (!reversedMap.containsKey(e.getKey())) {
                count++;
                from = e.getKey();
            }
        }
        if (count > 1) {
            return "null";
        }
        String to = map.get(from);
        while (to != null) {
            completePath.append(from).append("->").append(to).append(", ");
            from = to;
            to = map.get(from);
        }
        return completePath.toString();
    }

    public static void main(String[] args) {
        var map = new HashMap<String, String>() {{
            put("NewYork", "Chicago");
            put("Boston", "Texas");
            put("Missouri", "NewYork");
            put("Texas", "Missouri");
        }};
        System.out.println(tracePath(map));
    }
}
