package Sliding_Window;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int count=0;
        int maxlen=0;
        while(j<nums.length) {
            if(nums[j]==0) {
                count++;
            }
            if(nums[j]==0 && count>k) {
            while(nums[i]!=0) {
                i++;
            }
            i++;
            count--;
            }

            maxlen=Math.max(j-i+1, maxlen);
            j++;
        }
        return maxlen;
    }
}