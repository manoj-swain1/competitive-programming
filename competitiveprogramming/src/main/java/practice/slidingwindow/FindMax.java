package practice.slidingwindow;

public class FindMax {

  public int findMax(int[] arr, int k) {
    int max = Integer.MIN_VALUE;
    int sum = 0, i = 0, j = 0;
    while (j < arr.length) {
      sum += arr[j];
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        max = Math.max(sum, max);
        sum -= arr[i];
        i++;
        j++;
      }
    }
    return max;
  }

  public int findMaxAlternate(int[] arr, int k) {
    int max = Integer.MIN_VALUE;
    int sum = 0, i = 0, j = k;
    for (int x=0; x < k; x++) {
      sum += arr[x];
    }
    while (j < arr.length) {
      max = Math.max(sum, max);
      sum = sum - arr[i] + arr[j];
      i++;
      j++;
    }
    return max;
  }

  public static void main(String[] args) {
    FindMax findMax = new FindMax();
    int[] arr = new int[]{2, 5, 1, 8, 2, 9, 1};
    int k = 3;
    System.out.println(findMax.findMax(arr, k));
    System.out.println(findMax.findMaxAlternate(arr, k));
  }
}
