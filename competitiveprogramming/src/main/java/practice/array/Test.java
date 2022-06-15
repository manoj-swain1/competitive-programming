package practice.array;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test extends Thread {
    public void run() {
        System.out.println("blabla bala");
    }

    static public double average(int[] salary) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int j : salary) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        double totalSum = 0;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;


        for (int i = 0; i < salary.length; i++) {
            maxSalary = Math.max(maxSalary, salary[i]);
            minSalary = Math.min(minSalary, salary[i]);
            totalSum += salary[i];
        }
        return (totalSum - minSalary - maxSalary) / (salary.length - 2);
    }

    static int hammingWeight(int n) {
        int ones = 0;
        do {
            ones = ones + (n & 1);

            n = n >>> 1;
        } while (n != 0);

        return ones;

    }

    public static int difference_calculator(List<Integer> arr) {
        long indicator1 = 0;
        long indicator2 = 0;
        int i = 0;
        int count;

        while (i < arr.size()) {
            int n = arr.get(i);
            count = 1;
            if (i == arr.size() - 1)
                break;
            while (Objects.equals(arr.get(i), arr.get(i + 1))) {
                count++;
                i++;
                if (i == arr.size() - 1)
                    break;
            }
            i++;
            if (count == n)
                indicator1++;
        }

        count = 0;
        for (int j = 0; j < arr.size(); j++) {
            int n = arr.get(j);
            if (n == j + 1) {
                count = 1;
                while (Objects.equals(arr.get(j), arr.get(j + 1))) {
                    count++;
                    j++;
                    if (j == arr.size() - 1)
                        break;
                }
            }
            if (count == n) {
                indicator2++;
            }
        }

        return (int) Math.abs(indicator2 - indicator1);

    }


    public static void main(String[] args) {
        int[] arr = {1000, 5000, 4000, 7000};

    }


}

