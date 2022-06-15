package practice.slidingwindow;

import java.util.*;

public class OccurrenceOfAnagram {

  public int occurrenceOfAnagram(String s, String pattern) {

    Collection<String> c;
c=new TreeSet<>();
    List<Integer> anagramIndices=new ArrayList<>();
    var charOcuurence=new HashMap<String,Integer>();
    int uniqueCharacters=0;
    int i,j;
    i=j=0;
    int k=pattern.length();
    for(int x=0;x<pattern.length();x++){
      String ch=String.valueOf(pattern.charAt(x));
      if(charOcuurence.containsKey(ch)){
        charOcuurence.put(ch,charOcuurence.get(ch)+1);
      }else{
        charOcuurence.put(ch,1);
      }
    }

    uniqueCharacters=charOcuurence.size();

    while(j<s.length()){
      String ch=String.valueOf(s.charAt(j));
      if(charOcuurence.containsKey(ch)){
        charOcuurence.put(ch,charOcuurence.get(ch)-1);
      }
      if(charOcuurence.get(ch)==0){
        uniqueCharacters--;
      }
      if(j-i+1<k){
        j++;
      }else if(j-i+1==k){
        if(uniqueCharacters==0){
          anagramIndices.add(i);
        }
        if(charOcuurence.containsKey(ch)){
          charOcuurence.put(ch,charOcuurence.get(ch)+1);
        }
        if(charOcuurence.get(ch)==1){
          uniqueCharacters++;
        }
        i++;
        j++;
      }
    }
    return anagramIndices.get(0);
  }

  public static void main(String[] args) {
    OccurrenceOfAnagram o = new OccurrenceOfAnagram();
Integer[] arr={};
    String s = "abab";
    String ptrn = "ab";
    System.out.println(o.occurrenceOfAnagram(s, ptrn));
  }


}
