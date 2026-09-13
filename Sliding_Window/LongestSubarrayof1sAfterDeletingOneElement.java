package Sliding_Window;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
      int i=0;
         int j=0;
         int maxlen=0;
         int count=0;
         while(j<nums.length) {
            if(nums[j]==0 && count==1) {
                while(nums[i]!=0) {
                    i++;
                }
                i++;
            }
            if(nums[j]==0) {
                count=1;
            }
            maxlen=Math.max(maxlen,j-i+1);
            j++;
         }
         return maxlen-1;
        }
}
