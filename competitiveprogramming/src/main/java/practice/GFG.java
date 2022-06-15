package practice;

class GFG {

    // Function to print the
// elements of the array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Exchange array elements one by
// one from right to left side
// starting from the current position
// and ending at the target position
    static void swapMax(int[] arr, int target_position,
                        int current_position) {
        int aux = 0;
        for (int i = current_position;
             i > target_position; i--) {
            aux = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = aux;
        }
    }

    // Function to return the
// maximum number array
    static String maximizeArray(String string,
                                int length, int swaps) {
        int[] arr = new int[string.length()];
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[i] = chars[i] - '0';
        }


        // Start from the first index
        for (int i = 0; i < length; i++) {
            int max_index = 0, max = Integer.MIN_VALUE;

            // Search for the next K elements
            int limit = Math.min((swaps + i), length-1);

            // Find index of the maximum
            // element in next K elements
            for (int j = i; j <= limit; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    max_index = j;
                }
            }

            // Update the value of
            // number of swaps
            swaps -= (max_index - i);

            // Update the array elements by
            // swapping adjacent elements
            swapMax(arr, i, max_index);

            if (swaps == 0)
                break;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j);
        }
        return sb.toString();
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3};
        int length = arr.length;
        int swaps = 100;
        System.out.println(maximizeArray("1234", length, swaps));

    }
}
