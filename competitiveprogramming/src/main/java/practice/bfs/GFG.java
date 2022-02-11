package practice.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class GFG {

  // Method return t % N, where t is stored as
// a string
  public static int mod(String t, int N) {
    int r = 0;
    for (int i = 0; i < t.length(); i++) {
      r = r * 10 + (t.charAt(i) - '0');
      r %= N;
      System.out.println("r:"+r);
    }
    return r;
  }

  // method returns smallest multiple which has
// binary digits
  public static String getMinimumMultipleOfBinaryDigit(int N) {
    Queue<String> q = new LinkedList<String>();
    Set<Integer> visit = new HashSet<>();

    String t = "1";

    // In starting push 1 into our queue
    q.add(t);

    // loop until queue is not empty
    while (!q.isEmpty()) {

      // Take the front number from queue.
      t = q.remove();

      // Find remainder of t with respect to N.
      int rem = mod(t, N);
      System.out.println("rem"+rem);
      // If remainder is 0 then we have
      // found our solution
      if (rem == 0) {
        return t;
      }

      // If this remainder is not previously seen,
      // then push t0 and t1 in our queue
      else if (!visit.contains(rem)) {
        visit.add(rem);
        q.add(t + "0");
        q.add(t + "1");
      }
    }
    return "";
  }

  // Driver code
  public static void main(String[] args) {
    int N = 12;
    System.out.println(
        getMinimumMultipleOfBinaryDigit(N));
  }
}
