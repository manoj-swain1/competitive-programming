package practice.noon;

/*
  [1, 2, 1, 3, 1, 2, 9, -12]
   0, 1, 2, 3, 4, 5, 6, 7
   [6,7,4,2,-5,,2]
  target = 10
  ans=6
  sum =0
  i=0
  j=0
  while(j<end){

 */
/*
Range{
int low;
int upper;
}
1 3
6-8
5-10
7-10
ranges[]
visited=[0,1,]

  [0, 0, 1, 0, 0, 0, 0, 1, 7, 2, 0 ]
  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  i-arr[i]
  i+arr[i]
  0,3
 */
public class Solution {

  public static int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int minSubArrayLen = Integer.MAX_VALUE;
    int i, j;
    i = j = 0;

    while (j < nums.length) {
      sum = sum + nums[j];
      if (sum == target) {
        minSubArrayLen = Math.min(minSubArrayLen, j - i + 1);
        i++;
      }
      j++;
    }

    return Integer.MAX_VALUE == minSubArrayLen ? 0 : minSubArrayLen;
  }

  public static void main(String[] args) {
    int[] arr = {6, 7, 4, 2, -5, 2};
    System.out.println(minSubArrayLen(14, arr));
  }
}
