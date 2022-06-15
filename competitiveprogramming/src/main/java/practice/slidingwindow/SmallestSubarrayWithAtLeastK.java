package practice.slidingwindow;

public class SmallestSubarrayWithAtLeastK {

    public static int findMinSubArray(int S, int[] arr) {

        int i = 0, j = 0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while (j < arr.length) {
           sum+=arr[j];
           while(sum>=S){
              ans=Math.min(ans,j-i+1);
              sum-=arr[i];
              i++;
           }
           j++;
        }

        return ans;
    }
}
