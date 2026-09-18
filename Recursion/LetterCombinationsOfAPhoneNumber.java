import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> rec(int in, String digits, StringBuilder sb, List<String> list, Map<Character, String> map) {
        if(in>=digits.length()) {
            list.add(sb.toString());
            return list;
        }
        String s=map.get(digits.charAt(in));
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));
           list= rec(in+1,digits, sb, list, map);
            sb.deleteCharAt(sb.length()-1);
        }
        return list;
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        StringBuilder sb= new StringBuilder();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> list= new ArrayList<>();
        list=rec(0,digits,sb,list,map);
        return list;
    }
}