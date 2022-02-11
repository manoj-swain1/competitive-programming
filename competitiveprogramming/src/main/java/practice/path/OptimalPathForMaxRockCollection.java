package practice.path;

public class OptimalPathForMaxRockCollection {

  public static int optimalPath(int[][] arr) {

    int[][] dp = new int[arr.length][arr[0].length];

    for (int m = arr.length - 1; m >= 0; m--) {
      for (int n = 0; n < arr[0].length; n++) {
        if (m == arr.length - 1) {
          int x = n == 0 ? 0 : n - 1;
          dp[m][n] = arr[m][n] + dp[m][x];
        } else if (n == 0) {
          int x = m == arr.length - 1 ? arr.length - 1 : m+1;
          dp[m][n] = arr[m][n] + dp[x][n];
        } else {
          dp[m][n] = arr[m][n] + Math.max(dp[m + 1][n], dp[m][n - 1]);
        }
      }
    }
    return dp[0][arr[0].length - 1];
  }

  public static void main(String[] args) {
    int[][] arr =
        {{6, 0, 8, 1, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}};

    System.out.println(optimalPath(arr));
  }

}
