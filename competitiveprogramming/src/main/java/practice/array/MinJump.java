package practice.array;

public class MinJump {
    static int minJumps(int[] arr){
        int reach=0;
        int jump=0;
        int curr_reach=0;
        for(int i=0;i<arr.length;i++){
            if(i>reach) return -1;

            reach=Math.max(i+arr[i],reach);
            if(curr_reach==i && i!=arr.length-1){
                jump++;
                curr_reach=reach;
            }

        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr = {1, 12, 9,8,2, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
}
