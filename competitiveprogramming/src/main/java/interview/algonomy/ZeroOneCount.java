package interview.algonomy;

public class ZeroOneCount {

    public static void main(String[] args) {
        var ans=zeroOneCount(15000);
        System.out.println(ans[0]+":"+ans[1]);
    }

    private static int[] zeroOneCount(int n) {

        if(n<1 || n>10000){
            throw new IllegalArgumentException("Invalid input");
        }
        int[] ans=new int[2];
        ans[0]=1;
        while(n>0){
            int temp=ans[0];
            ans[0]=ans[0]+ans[1];
            ans[1]=temp;
            n--;
        }

        return ans;
    }
}
