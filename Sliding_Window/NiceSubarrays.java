package Sliding_Window;

import java.util.HashMap;

public class NiceSubarrays {
     public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int ans=0;
         for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                nums[i]=0;
            }
            else {
                nums[i]=1;
            }
         }
         map.put(0,1);
         int prev=0;
         int sum=0;
         for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)) {
                ans+=map.get(sum-k);
            }
            nums[i]+=prev;
            prev=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

         }

         return ans;
    }
}
