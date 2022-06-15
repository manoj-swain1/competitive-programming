package interview.priceline;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private static List<Integer> getOddNumbers(List<List<Integer>> list){
        return list.stream()
                .flatMap(Collection::stream)
                .filter(n -> n%2==1)
                .collect(Collectors.toList());

    }
}
