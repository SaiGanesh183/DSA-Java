package Sliding_Window;

import java.util.HashSet;

public class MaximumErasureValue {
     public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int maxsum=0;
        HashSet<Integer> set= new HashSet<>();
        while(j<nums.length) {
            while(set.contains(nums[j])) {
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            maxsum=Math.max(sum,maxsum);
            j++;
        }
        return maxsum;
    }
}
