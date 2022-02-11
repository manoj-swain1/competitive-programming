package practice.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    int i=0, j=1;
    Set<Integer> set = new HashSet<Integer>();
    while (j < nums.length) {

      if (nums[i] != nums[j]) {
        set.add(nums[j]);
      }else{
        return true;
      }
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        set.remove(nums[i]);
        i++;
        j++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2,1, 3, 1};
    int k =3;
    System.out.println(containsNearbyDuplicate(arr, k));
  }
}
