package practice;

public class BuildHeap {

  // To heapify a subtree rooted with node i which is
  // an index in arr[].Nn is size of practice.heap
  static void heapify(int arr[], int n, int i) {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
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

  // Driver Code
  public static void main(String args[]) {
    int[] arr = {1, 3, 5, 4, 6, 10, 10, 9, 8, 15, 17};

    int k = 3;
    int turn = 0;
    int candiesEaten = 0;
    while (turn < k) {
      buildHeap(arr);
      candiesEaten += arr[0];
      arr[0] = arr[0] / 2;
      turn++;
    }
    System.out.println(candiesEaten);
  }
}