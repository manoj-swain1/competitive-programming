package practice.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindFirstNegative {

  public List<Integer> findFirstNegative(int[] arr, int k) {
    List<Integer> output = new ArrayList<>();
    int i = 0, j = 0;
    List<Integer> negativeList = new ArrayList<>();
    while (j < arr.length) {
      if (arr[j] < 0) {
        negativeList.add(arr[j]);
      }
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        if (negativeList.isEmpty()) {
          output.add(0);
        } else {
          output.add(negativeList.get(0));
          if (arr[i] == negativeList.get(0)) {
            negativeList.remove(0);
          }
        }
        i++;
        j++;
      }
    }
    return output;
  }


  public static void main(String[] args) {
    FindFirstNegative findMax = new FindFirstNegative();
    int[] arr = new int[]{2, -1, -7, 8, -15, 30, 9, 1};
    int k = 3;
    findMax.findFirstNegative(arr, k).forEach(System.out::println);
  }
}
