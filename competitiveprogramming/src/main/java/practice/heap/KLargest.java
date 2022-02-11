package practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {
  public static int findKthLargest(int[] nums, int k) {
    int ans = 0;
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int num : nums) {
      q.add(num);

    }

    while (k > 0) {
      ans = q.poll();
      k--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] ip = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(ip, 2));
  }
}
