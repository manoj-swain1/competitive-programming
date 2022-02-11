package practice.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatAllWords {

  public static List<Integer> findSubstring(String s, String[] words) {
    String p;
    StringBuilder pattern = new StringBuilder();
    int replace = 1;
    for (String word : words) {
      s=s.replaceAll(word, replace + "");
      pattern.append(replace + "");
      replace++;
    }
    p = pattern.toString();

    List<Integer> anagramIndices = new ArrayList<>();
    Map<String, Integer> charOcuurence = new HashMap<String, Integer>();
    int uniqueCharacters;
    int i, j;
    i = j = 0;
    int k = p.length();
    for (int x = 0; x < p.length(); x++) {
      String ch = String.valueOf(p.charAt(x));
      if (charOcuurence.containsKey(ch)) {
        charOcuurence.put(ch, charOcuurence.get(ch) + 1);
      } else {
        charOcuurence.put(ch, 1);
      }
    }

    uniqueCharacters = charOcuurence.size();

    while (j < s.length()) {
      String ch = String.valueOf(s.charAt(j));
      if (charOcuurence.containsKey(ch)) {
        charOcuurence.put(ch, charOcuurence.get(ch) - 1);
        if (charOcuurence.get(ch) == 0) {
          uniqueCharacters--;
        }
      }

      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        if (uniqueCharacters == 0) {
          anagramIndices.add(i);
        }
        ch = String.valueOf(s.charAt(i));
        if (charOcuurence.containsKey(ch)) {
          charOcuurence.put(ch, charOcuurence.get(ch) + 1);
          if (charOcuurence.get(ch) == 1) {
            uniqueCharacters++;
          }
        }

        i++;
        j++;
      }
    }

    return anagramIndices;

  }

  public static void main(String[] args) {
    String[] arr = {"foo", "bar"};
    System.out.println(findSubstring("barfoothefoobarman", arr));
  }
}
