

import java.util.Arrays;
class FrogJump {
    
    int rec(int in, int [] height, int [] dp) {
        if(in==height.length-1) {
            return 0;
        }
        
        if(dp[in]!=-1) {
            return dp[in];
        }
        int case1=Math.abs(height[in]-height[in+1]) + rec(in+1, height, dp);
        int case2=Integer.MAX_VALUE;
        if(in+2<height.length) {
             case2=Math.abs(height[in]-height[in+2]) + rec(in+2, height, dp);
        }
        dp[in]=Math.min(case1,case2);
        return dp[in];
    }
    
    int minCost(int[] height) {
        int [] dp= new int[height.length];
        Arrays.fill(dp,-1);
          return rec(0, height, dp);
          
    }
}