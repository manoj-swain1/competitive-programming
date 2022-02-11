package practice.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindMaxOfAllSubArray {

  public List<Integer> findMaxOfAllSubArray(int[] arr, int k) {
    int i = 0, j = 0;
    List<Integer> result = new ArrayList<>();
    Deque<Integer> max = new LinkedList<Integer>();
    while (j < arr.length) {
      while (max.size() > 0
          && max.peekLast() < arr[j]) {
        max.pollLast();
      }
      max.add(arr[j]);
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        result.add(max.peekFirst());
        if (arr[i] == max.peekFirst()) {
          max.pollFirst();
        }
        i++;
        j++;
      }
    }
    return result;
  }

  /**
   * int[] res=new int[nums.length-k+1]; int i,j; i=j=0; List<Integer> max=new ArrayList<>(); int
   * x=0; while(j<nums.length){ while(!max.isEmpty() && max.get(max.size()-1) < nums[j]){
   * max.remove(max.size()-1); } max.add(nums[j]); if(j-i+1<k){ j++; }else if(j-i+1==k){
   * res[i]=max.get(0); if(max.get(0)==nums[i]){ max.remove(0); } i++; j++; } } return res;
   *
   * @param args
   */

  public static void main(String[] args) {
    FindMaxOfAllSubArray findMax = new FindMaxOfAllSubArray();
    int[] arr = new int[]{1, 3, 1, 2, 0, 5};
    int k = 3;
    System.out.println(findMax.findMaxOfAllSubArray(arr, k).stream().map(String::valueOf)
        .collect(Collectors.joining()));
    arr = new int[]{1};
    k = 1;
    findMax.findMaxOfAllSubArray(arr, k).forEach(System.out::println);
  }
}
