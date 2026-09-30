package DynamicProgramming;
import java.util.Arrays;

class ClimbingStairs {
    public int rec(int n, int[] dp) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        int path1=rec(n-1,dp);
        int path2=rec(n-2,dp);
        dp[n]=path1+path2;
        return dp[n];
    }

    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        int ans=rec(n,dp);
        return ans;
    }
}