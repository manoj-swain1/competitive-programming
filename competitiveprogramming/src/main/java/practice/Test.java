package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list = Collections.synchronizedList(list);
        for (Integer i : Collections.synchronizedList(list)) {
            list.remove(i);
            System.out.println(i);
        }
        list.forEach(System.out::println);
    }
}

