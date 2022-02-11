package practice;

public class ScrambleWords {

  public static boolean isScramble(String s1, String s2) {
    int[] chars=new int[256];
    int[] chars2=new int[256];
    for(int i=0;i<s1.length();i++){
      chars[s1.charAt(i)-'a']++;
    }
    for(int i=0;i<s2.length();i++){
      chars2[s2.charAt(i)-'a']++;
    }
    boolean allMatch=true;
    for(int i=0;i<chars.length;i++){
      if(chars[i]!=chars2[i]){
        allMatch=false;
        break;
      }
    }

    return allMatch;

  }

  public static void main(String[] args) {
    System.out.println(isScramble("abcde","caebd"));
  }
}
