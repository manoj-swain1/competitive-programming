package practice.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MedianSlidingwindow {

  public static double[] medianSlidingWindow(int[] nums, int k) {
    double[] r = new double[nums.length - k + 1];
    int i, j;
    i = j = 0;
    List<Integer> sorted = new ArrayList<>();
    while (j < nums.length) {
      if (sorted.isEmpty() || nums[j] < sorted.get(0)) {
        sorted.add(0, nums[j]);
      }
      if (j - i + 1 == k) {

        if (k % 2 == 0) {
          r[i] = ((double) sorted.get(k / 2) + (double) sorted.get(k / 2 - 1)) * 0.5;
        } else {
          r[i] = sorted.get(k / 2);
        }
        int index = sorted.indexOf(nums[i]);
        sorted.remove(index);
        i++;
      }
      j++;
    }

    return r;
  }

  static void heapify(int arr[], int n, int i) {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    if (l < n && arr[l] < arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] < arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  static void buildHeap(int[] arr) {
    int n = arr.length;
    int startIdx = (n / 2) - 1;

    for (int i = startIdx; i >= 0; i--) {
      heapify(arr, n, i);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println(medianSlidingWindow(arr, k));
  }
}
