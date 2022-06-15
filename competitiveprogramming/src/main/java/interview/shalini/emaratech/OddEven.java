package interview.shalini.emaratech;

import java.util.LinkedList;
import java.util.List;

public class OddEven {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 10, 4, 7, 3, 20, 6, 30};
        int[] result = awesomeSort(arr.length, arr);

        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    private static int[] awesomeSort(int length, int[] arr) {
        List<Integer> evenNumbers = new LinkedList<>();
        List<Integer> evenNumbersDivisibleBy5 = new LinkedList<>();
        List<Integer> oddNumbers = new LinkedList<>();
        findEvenNumbers(arr, evenNumbers, evenNumbersDivisibleBy5, oddNumbers);

        return prepareResult(evenNumbers, evenNumbersDivisibleBy5, oddNumbers, length);
    }

    private static int[] prepareResult(List<Integer> evenNumbers, List<Integer> evenNumbersDivisibleBy5, List<Integer> oddNumbers, int length) {
        int i = 0;
        int[] result = new int[length];

        evenNumbersDivisibleBy5.sort((n1, n2) -> n2 - n1);

        for (int n : evenNumbersDivisibleBy5) {
            result[i++] = n;
        }
        for (int n : evenNumbers) {
            result[i++] = n;
        }
        for (int n : oddNumbers) {
            result[i++] = n;
        }

        return result;
    }

    private static void findEvenNumbers(int[] arr, List<Integer> evenNumbers,
                                        List<Integer> evenNumbersDivisibleBy5,
                                        List<Integer> oddNumbers) {
        for (int n : arr) {
            if (n % 2 == 0) {
                addEvenNumbers(evenNumbers, evenNumbersDivisibleBy5, n);
            } else {
                oddNumbers.add(n);
            }
        }
    }

    private static void addEvenNumbers(List<Integer> evenNumbers, List<Integer> evenNumbersDivisibleBy5, int n) {
        if (n % 5 == 0) {
            evenNumbersDivisibleBy5.add(n);
        } else {
            evenNumbers.add(0, n);
        }

    }
}
