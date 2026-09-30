package DynamicProgramming;

import java.util.Arrays;

class HouseRobber {
    public int rec(int in, int[]nums, int[] dp) {
        if(in>=nums.length) {
            return 0;
        }
        if(dp[in]!=-1) {
            return dp[in];
        }
       int ans1= nums[in]+rec(in+2, nums,dp);
       int ans2= rec(in+1, nums, dp);
       dp[in]=Math.max(ans1, ans2);
       return dp[in];
    }
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=rec(0, nums, dp);
        return ans;
    }
}