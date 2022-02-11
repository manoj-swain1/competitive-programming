package practice.array;

public class SquaresOfSortedArray {
  public static int[] sortedSquares(int[] nums) {
    int i=0;
    int j=nums.length-1;
    int k=j;
    int[] res=new int[nums.length];
    while(i<=j){
      if(Math.abs(nums[i])>Math.abs(nums[j])){
        res[k--]=nums[i]*nums[i];
        i++;
      }else{
        res[k--]=nums[j]*nums[j];
        j--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr={-4,-1,0,3,10};
    System.out.println(sortedSquares(arr));
  }
}
