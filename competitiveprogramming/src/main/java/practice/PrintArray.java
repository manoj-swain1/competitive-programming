package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintArray {

    public static String printArray(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static String printList(List<?> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
