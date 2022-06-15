package practice.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class FindMaxOfAllSubArray {

    public List<Integer> findMaxOfAllSubArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0, j = 0, m = 0;
        Deque<Integer> max = new ArrayDeque<>();
        while (j < nums.length) {
            while (!max.isEmpty() && max.peekLast() < nums[j]) {
                max.pollLast();
            }
            max.add(nums[j]);
            if (j - i + 1 == k) {
                ans[m++] = max.peekFirst();
                if (max.size() > 0 && max.peekFirst() == nums[i]) {
                    max.pollFirst();
                }
                i++;
            }
            j++;
        }

        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }



    public static void main(String[] args) {
        FindMaxOfAllSubArray findMax = new FindMaxOfAllSubArray();
        int[] arr = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(findMax.findMaxOfAllSubArray(arr, k).stream().map(String::valueOf)
                .collect(Collectors.joining(",")));
        arr = new int[]{1};
        k = 2;
        findMax.findMaxOfAllSubArray(arr, k).forEach(System.out::println);
    }
}
