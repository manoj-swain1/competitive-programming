package practice.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        if (k > r) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (l <= r) {
            pq.offer(arr[l]);
            l++;
        }
        Integer ans = -1;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }
        return ans != null ? ans : -1;
    }

    public static int kthLargest(int[] arr, int l, int r, int k) {
        if (k > r) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (l <= r) {
            pq.offer(arr[l]);
            l++;
        }
        Integer ans = -1;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }
        return ans != null ? ans : -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 1, 2, 3,11,12};
        System.out.println(kthSmallest(a, 0, a.length - 1, 3));
        System.out.println(kthLargest(a, 0, a.length - 1, 3));
    }
}
