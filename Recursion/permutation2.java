import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> rec(int [] nums, boolean[]vis, List<Integer> list, List<List<Integer>> mainlist){
        if(nums.length==list.size()) {
            mainlist.add(new ArrayList<>(list));
            return mainlist;
        }
        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i]==nums[i-1] && !vis[i-1]) {
                continue;
            }
            if(!vis[i]) {
                vis[i]=true;
                list.add(nums[i]);
                mainlist=  rec(nums, vis, list, mainlist);
                list.remove(list.size()-1);
                vis[i]=false;
            } 
        }
        return mainlist;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis= new boolean[nums.length];
        List<Integer> list= new ArrayList<>();
        List<List<Integer>> mainlist= new ArrayList<>();
        mainlist=rec(nums, vis, list, mainlist);
        return mainlist;
    }
}