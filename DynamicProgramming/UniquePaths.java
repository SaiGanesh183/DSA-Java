package DynamicProgramming;
import java.util.Arrays;

class UniquePaths {
 public int rec(int i, int j, int m, int n, int[][] dp) {
     if (i >= m || j >= n) {
        return 0;
    }
     if (i == m - 1 && j == n - 1) {
        return 1;
    }
    if(dp[i][j]!=-1) {
        return dp[i][j];
    }
    int r1 = rec(i, j + 1, m, n, dp);
    int r2 = rec(i + 1, j, m, n, dp);
    dp[i][j]=r1+r2;
    return dp[i][j];
}
    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(0,0,m,n,dp);
        
    }
}