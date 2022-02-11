//package practice.bfs;
//
//public class CovidInfection {
//
//  public static int helpaterp(int[][] hospital) {
//    int r = hospital.length;
//    int c = hospital[0].length;
//    int count = 0;
//    for (int i = 0; i < r; i++) {
//      for (int j = 0; j < c; j++) {
//        as=0;
//        if(hospital[i][j]==1) {
//          helper(hospital, i, j, r, c);
//
//        }
//      }
//    }
//    for (int i = 0; i < r; i++) {
//      for (int j = 0; j < c; j++) {
//        if(hospital[i][j]==1) {
//          count=-1;
//          break;
//        }
//      }
//    }
//    return count ;
//  }
//
//  private static void helper(int[][] hospital, int i, int j, int r, int c) {
//    if (i < 0 || i >= r || j < 0 || j >= c || hospital[i][j] ==0  || hospital[i][j]==3) {
//      return;
//    }
////    if (hospital[i][j] == 1) {
//      hospital[i][j] = 3;
////    }
//    helper(hospital, i + 1, j, r, c);
//    helper(hospital, i, j + 1, r, c);
//    helper(hospital, i - 1, j, r, c);
//    helper(hospital, i, j - 1, r, c);
//  }
//
//  public static void main(String[] args) {
//    int[][] hospital ={{1,1,1,0},{0,0,1,0},{0,0,0,1}};
//    int ans = helpaterp(hospital);
//    System.out.println(ans);
//  }
//}
