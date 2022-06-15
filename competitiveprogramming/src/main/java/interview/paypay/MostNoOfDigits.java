package interview.paypay;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MostNoOfDigits {
    static int[] solution(int[] a) {

        Map<Integer, Long> occurrences = Arrays.stream(a)
                .mapToObj(i -> ((Integer) i).toString())
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.groupingBy(p -> p,
                        Collectors.counting()));

        int max = occurrences.values()
                .stream()
                .mapToInt(Math::toIntExact)
                .max().orElse(0);

        return occurrences.entrySet().stream()
                .filter(e -> max == e.getValue())
                .mapToInt(Map.Entry::getKey).toArray();

    }

    public static void main(String[] args) {
        int[] a = {35, 22, 3, 557, 38, 41};
        System.out.println(Arrays.toString(solution(a)));
    }
}
