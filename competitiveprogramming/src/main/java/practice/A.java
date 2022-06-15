package practice;

import java.util.ArrayList;
import java.util.List;

public class A {
    public int solve(int n) {
        List<Integer> num = new ArrayList<>();

        while (n > 0) {
            num.add(n % 10);
            n = n / 10;
        }

        int N = num.size();

        int firstMaxLeft = 1;
        while (firstMaxLeft < N && num.get(firstMaxLeft) >= num.get(firstMaxLeft - 1)) {
            firstMaxLeft++;
        }
        if (firstMaxLeft < N) {
            int indexToSwapWith = 0;
            while (num.get(indexToSwapWith) <= num.get(firstMaxLeft)) {
                indexToSwapWith++;
            }
            swap(num, firstMaxLeft, indexToSwapWith);
        }

        reverseToFront(num,firstMaxLeft-1);

        int ans = 0;
        for (int l = num.size() - 1; l >= 0; l--) {
            ans = (ans * 10) + num.get(l);
        }

        return ans;
    }

    private void reverseToFront(List<Integer> lst, int index) {
        int s=0,e=index;
        while(s<e){
            swap(lst,s,e);
            s++;
            e--;
        }
    }

    private void swap(List<Integer> lst, int i, int j) {
        int temp = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, temp);
    }


    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.solve(52214));
    }
}