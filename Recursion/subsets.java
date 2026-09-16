import java.util.ArrayList;
import java.util.List;

class Recursion {
    public List<List<Integer>> rec(int [] nums, int in,List<List<Integer>> mainlist, List<Integer> list ) {
        if(in==nums.length) {
            mainlist.add(new ArrayList<>(list));
            return mainlist;
        }
        
        list.add(nums[in]);
       mainlist= rec(nums, in+1, mainlist, list);
        list.remove(list.size()-1);
        mainlist=rec(nums, in+1, mainlist, list);
        return mainlist;
    
    }
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> mainlist = new ArrayList<>();
         List<Integer> list= new ArrayList<>();
        mainlist=rec(nums,0,mainlist,list);
        return mainlist;
    }
}
