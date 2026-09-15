import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=  new Stack<>();
        for(int i=0;i<asteroids.length;i++) {
            int elem=asteroids[i];
            int flag=1;
            if(elem<0) {
            while(!st.isEmpty() && st.peek()>0 ) {
                if(Math.abs(elem)==st.peek()) {
                    st.pop();
                    flag=0;
                    break;
                }
               else if(Math.abs(elem)>st.peek()) {
                    st.pop();
                }
                else {
                    flag=0;
                    break;
                }
            }
            }
            if(flag!=0) {
            st.push(elem);
            }
        }
 int ans[]= new int[st.size()];
 int in=0;
        for(int num: st) {
            ans[in++]=num;
        }
        return ans;
    }
}

