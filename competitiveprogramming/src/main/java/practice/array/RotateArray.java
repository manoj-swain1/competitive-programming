package practice.array;

import practice.PrintArray;

public class RotateArray {

    public static void rotateArray(int[] arr) {
        int n = arr.length;
        reverse(arr, 0, n - 1);
        reverse(arr, 1, n - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1000, 5000, 4000, 7000};
        rotateArray(arr);
        System.out.println(PrintArray.printArray(arr));
    }
}
