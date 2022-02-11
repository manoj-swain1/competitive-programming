package practice.strings;

import java.util.Scanner;

public class LongestWorld {

    public static String LongestWord(String sen) {
        sen=sen.concat(" ");
        char[] s = sen.toCharArray();
        int i = 0, j = 0;
        int sIndex = 0, maxLength = 0;
        while (j < s.length) {
            if (!(isSmallCharacter(s[j])
                    || isLargeCharacter(s[j]))) {

                if (j - i > maxLength) {
                    maxLength = Math.max(maxLength, j - i);
                    sIndex = i;

                }
                i = j + 1;
            }
            j++;
        }
        System.out.print(sIndex + ":" + maxLength);
        return sen.substring(sIndex, sIndex + maxLength);
    }

    private static boolean isSmallCharacter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private static boolean isLargeCharacter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }

}
