package interview.twilio;

import java.util.*;

public class SpaceCount {
    public static int segment(int x, List<Integer> space) {


        int i = 0, j = 0;
        Deque<Integer> min = new ArrayDeque<>();
        List<Integer> minima = new ArrayList<>();
        while (j < space.size()) {
            while (!min.isEmpty() && min.peekLast() > space.get(j)) {
                min.pollLast();
            }
            min.add(space.get(j));
            if (j - i + 1 == x) {

                minima.add(min.peekFirst());
                if (min.size() > 0 && Objects.equals(min.peekFirst(), space.get(i))) {
                    min.pollFirst();
                }
                i++;
            }
            j++;
        }


        return minima.stream().mapToInt(v -> v).max().orElse(-1);

    }

    public static void main(String[] args) {

        System.out.println(segment(3, Arrays.asList(2, 5, 4, 6, 8)));
    }
}
