package interview.microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

public class Relocation {
    public static int solution(int[] A) {
        int sum = 0;
        int ans = 0;
        Deque<Integer> negatives = new ArrayDeque<>();
        for (int value : A) {
            sum += value;
            if (value < 0) {
                negatives.add(value);
            }
            while (sum < 0) {
                if (!negatives.isEmpty()) {
                    ans++;
                    sum -= negatives.pollFirst();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {10, -10, -1, -1, 10};
        System.out.println(solution(a));
        int[] b = {-1, -1, -1, 1, 1, 1, 1};
        System.out.println(solution(b));
        a = new int[]{5, -3, -2, 1};
        System.out.println(solution(a));
    }
}
