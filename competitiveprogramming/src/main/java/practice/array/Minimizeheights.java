package practice.array;

import java.util.Arrays;

public class Minimizeheights {
    static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);

        int ans = arr[n-1] - arr[0];

        int smallest = arr[0]+k;
        int largest = arr[n-1]-k;

        int mi,ma;

        for(int i = 0; i<n-1; i++) {
            mi = Math.min(smallest,arr[i+1]-k);
            ma = Math.max(largest, arr[i]+k);

            //for not negative
            if(mi<0)continue;

            ans = Math.min(ans, ma-mi);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,10};
        System.out.println(getMinDiff(arr, arr.length, 5));
    }
}
