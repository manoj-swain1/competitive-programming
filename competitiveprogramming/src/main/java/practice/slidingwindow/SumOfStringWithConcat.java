package practice.slidingwindow;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumOfStringWithConcat {

  public int sumOfStringWithConcat(String s, String[] words) {
    String pattern;
    StringBuilder p = new StringBuilder();
    for (String word : words) {
      String asciiSum = String.valueOf(word.chars().sum());
      s=s.replaceAll(word, asciiSum);
      p.append(asciiSum);
    }
    pattern = p.toString();
    var charOccurrence = pattern.chars().mapToObj(Character::toString)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    var k = pattern.length();

    int i = 0, j = 0;
    var uniqueCharacters = charOccurrence.size();
    var anagramCount = 0;
    var anagramIndex = new ArrayList<>();
    while (j < s.length()) {
      String character = String.valueOf(s.charAt(j));
      if (charOccurrence.get(character) != null) {
        charOccurrence.put(character, charOccurrence.get(character) - 1L);
      }
      if (charOccurrence.get(character) == 0) {
        uniqueCharacters--;
      }
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {

        if (uniqueCharacters == 0) {
          anagramIndex.add(i);
          anagramCount++;
        }
        character = String.valueOf(s.charAt(i));
        if (charOccurrence.get(character) != null) {
          charOccurrence.put(character, charOccurrence.get(character) + 1L);

        }
        if (charOccurrence.get(character) == 1) {
          uniqueCharacters++;
        }
        i++;
        j++;
      }

    }
    return anagramCount;

  }

  public static void main(String[] args) {
    SumOfStringWithConcat o = new SumOfStringWithConcat();

    String s = "abab";
    String[] ptrn = {"ab"};
    System.out.println(o.sumOfStringWithConcat(s, ptrn));
  }


}
