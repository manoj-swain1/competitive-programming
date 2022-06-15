package practice.hashtables;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static int findFirstUnique(int[] arr) {
        int result = -1;

        LinkedHashMap<Integer, Integer> count = new LinkedHashMap<>();
        for (int j : arr) {
            count.put(j, count.getOrDefault(j, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e:count.entrySet()){
            if(e.getValue()==1){
                return e.getKey();
            }
        }
        return result;
    }
}
