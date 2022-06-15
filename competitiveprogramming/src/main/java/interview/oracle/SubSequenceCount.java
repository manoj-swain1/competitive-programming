package interview.oracle;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceCount {
    private static List<Character[]> substringCount(String s) {
        List<Character[]> res = new ArrayList<>();
        int t = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i == s.length() - 1) {
                setResult(s, res, t, i+1);
            } else if (s.charAt(i) != s.charAt(i - 1)) {
                setResult(s, res, t, i);
                t = i;
            }
        }
        return res;
    }

    private static void setResult(String s, List<Character[]> res, int t, int i) {
        System.out.println(s.charAt(i - 1) + "::" + Character.forDigit(i - t, 10));
        Character[] ch = new Character[2];
        ch[0] = s.charAt(i - 1);
        ch[1] = Character.forDigit(i - t, 10);
        res.add(ch);
    }

    public static void main(String[] args) {
        substringCount("aabbccbcccccccccaaaaaa");
    }
}

class Result {
    char key;
    int count;


}