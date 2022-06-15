package interview.singtel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaddlePoint {

    public static int findSaddlePoint(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            int min = mat[i][0], colIndex = 0;
            for (int j = 1; j < n; j++) {
                if (min >= mat[i][j]) {
                    min = mat[i][j];
                    colIndex = j;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int k = 0; k < n; k++) {
                max = Math.max(max, mat[k][colIndex]);
            }

            if (min == max) {
                return max;
            }
        }

        // If Saddle Point not found
        return -1;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int n = Integer.parseInt(in.readLine());
        int[][] matrix = new int[n][n];
        int i = 0;
        while (i < n) {
            line = in.readLine();
            String[] data = line.split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }
            i++;
        }

        System.out.println(findSaddlePoint(matrix, n));

    }
}
