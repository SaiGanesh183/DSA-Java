import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> rec(int num, int k, int n, int sum,List<Integer> li, List<List<Integer>> mainli) {
        if(li.size()==k) {
            if(sum==n) {
                mainli.add(new ArrayList<>(li));
            }
           return mainli; 
        }
        if(num>9) {
            return mainli;
        }
sum+=num;
li.add(num);
mainli=rec(num+1,k,n,sum,li,mainli);
li.remove(li.size()-1);
sum-=num;
mainli=rec(num+1,k,n,sum,li,mainli);
return mainli;

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> li= new ArrayList<>();
        List<List<Integer>> mainli= new ArrayList<>();
        mainli=rec(1,k,n,0,li,mainli);
        return mainli;
    }
}