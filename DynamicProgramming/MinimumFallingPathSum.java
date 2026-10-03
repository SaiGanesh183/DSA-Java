import java.util.Arrays;

public class MinimumFallingPathSum {
    int rec(int i, int j, int[][] matrix, int[][] dp) {
        if(i>=matrix.length || j<0 || j>=matrix[0].length) {
            return 100000;
        }
        if(dp[i][j]!=-10001) {
            return dp[i][j]; 
        }
        if(i==matrix.length-1) {
            return matrix[i][j];
        }

      int sum1= matrix[i][j]+ rec(i+1, j-1, matrix, dp);
      int sum2= matrix[i][j]+ rec(i+1, j, matrix,  dp);
      int sum3= matrix[i][j]+ rec(i+1, j+1, matrix,  dp);
      dp[i][j]=Math.min(sum1, Math.min(sum2, sum3));
      return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int [][] dp= new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i],-10001);
        }
        int minsum=Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++) {
            minsum=Math.min(minsum, rec(0,j,matrix, dp));
        }
        return minsum;
    }

}
