package interview.shalini.morganstanley;

public class DifferenceIndicator {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3, 5, 5, 5, 5, 5};
        System.out.println(findDifference(arr));
    }

    private static int findDifference(int[] arr) {

        int indicator1 = findFirstIndicator(arr);
        int indicator2 = findSecondIndicator(arr);
        return Math.abs(indicator1 - indicator2);
    }

    private static int findSecondIndicator(int[] arr) {
        int indicator = 0;
        int count;

        for (int i = 0; i < arr.length; i++) {
            count = 1;
            int startingIndex = i;
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            if (startingIndex+1 <= count) {
                indicator++;
            }
        }
        return indicator;
    }

    private static int findFirstIndicator(int[] arr) {

        int indicator = 0;
        int count;

        for (int i = 0; i < arr.length; i++) {
            count = 1;
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }
            if (arr[i] == count) {
                indicator++;
            }
        }
        return indicator;
    }
}
