class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<num.length();i++) {
            if(st.isEmpty()) {
                st.push(num.charAt(i));
            }
            else {
              while(!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
             st.push(num.charAt(i));
            }
        }
         while (k > 0) {
            st.pop();
            k--;
        }
    StringBuilder ans = new StringBuilder();
    while(!st.isEmpty()) {
        ans.append(st.pop());
    }
    ans.reverse();
    int i=0;
    while(i<ans.length() && ans.charAt(i)=='0'){
            i++;
        }

       if(ans.length()==0 || i==ans.length()) {
        return "0";
       }
       return ans.substring(i); 
    
 
    


    }
}