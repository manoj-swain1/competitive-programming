package practice;

public class SpecialNumber {

  public static long solution(int n, int s) {
    int start = (int) (Math.pow(10, n) - 1);
    int end = (int) Math.pow(10, n - 1);

    int i = start;
    while (i >= end) {
      int cur = 0;
      int temp = i;
      while (temp != 0) {
        cur = cur + temp % 10;
        temp = temp / 10;
      }
      if (cur == s) {
        return i;
      } else {
        i--;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(solution(3, 198));
  }

}
