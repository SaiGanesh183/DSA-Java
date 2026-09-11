package Sliding_Window;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double temp=0;
        double avg=0;
        for(int i=0;i<k;i++) {
            temp+=nums[i];
        }
        avg=temp/k;
        int i=0;
        int j=k;
        while(j<nums.length) {
            temp+=nums[j];
            temp-=nums[i];
            avg=Math.max(avg,temp/k);
            j++;
            i++;
        }
        return avg;
    }
}