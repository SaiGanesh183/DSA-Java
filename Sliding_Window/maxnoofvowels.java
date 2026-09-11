package Sliding_Window;

public class maxnoofvowels {
    public boolean isvowel(char ch) {
        return (ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    public int maxVowels(String s, int k) {
        int ans=0;
        for(int i=0;i<k;i++) {
            if(isvowel(s.charAt(i))) {
                ans++;
            }
        }
        int i=0;
        int j=k;
        int maxans=ans;
        while(j<s.length()) {
            if(isvowel(s.charAt(j))) {
                ans++;
            }
            if(isvowel(s.charAt(i))) {
                ans--;
            }
            maxans=Math.max(maxans,ans);
            j++;
            i++;
        }
        return maxans;
   
    }
}
