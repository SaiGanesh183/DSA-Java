package Sliding_Window;

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map= new HashMap<>();
        int count=0;
        for(int i=0;i<s1.length();i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }
        int k=map.size();
        for(int i=0;i<s1.length();i++) {
            if(map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i)).equals(0)) {
                    count++;
                    if(count==k) {
                        return true;
                    }
                }
            }
        }
        int i=0;
        int j=s1.length();
        while(j<s2.length()) {
            char incom=s2.charAt(j);
            char outcom=s2.charAt(i);
            if(map.containsKey(outcom)) {
                map.put(outcom, map.get(outcom)+1);
                if(map.get(outcom).equals(1)) {
                    count--;
                }
            }
             if(map.containsKey(incom)) {
                map.put(incom, map.get(incom)-1);
                if(map.get(incom).equals(0)) {
                    count++;
                    if(count==k) {
                        return true;
                    }
                }
            }
            j++;
            i++;
        }
        return false;
    }
}