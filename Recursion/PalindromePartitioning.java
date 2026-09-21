import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean ispalindrome(int in1, int in2, String s) {
        while(in1<in2) {
            if(s.charAt(in1)!=s.charAt(in2)) {
                return false;
            }
            in1++;
            in2--;
        }
        return true;
    }
    public List<List<String>> rec(int in,String s, int prev ,int len, List<String> list, List<List<String>> mainlist) {  
        if(in==s.length()) {
            if(len==s.length()) {
                mainlist.add(new ArrayList<>(list));
            }
            return mainlist;
        }

       mainlist= rec(in+1,s,prev,len, list, mainlist);
       int tr=0;
        if(ispalindrome(prev,in,s)) {
            tr=1;
            list.add(s.substring(prev,in+1));
            len+=in-prev+1;
        }
        mainlist=rec(in+1,s,in+1, len, list, mainlist);
        if(tr==1) {
            list.remove(list.size()-1);
        }


        return mainlist;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> mainlist= new ArrayList<>();
        List<String> list= new ArrayList<>();
        mainlist=rec(0,s,0,0,list,mainlist);
        return mainlist;
    }
}