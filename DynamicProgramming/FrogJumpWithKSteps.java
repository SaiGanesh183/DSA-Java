import java.util.HashMap;

class FrogJumpWithKSteps {
    private boolean rec( int curr, int k, int [] stones, HashMap<Integer,Integer> map, boolean[][] dp) {
        if(curr==stones[stones.length-1]) {
            return true;
        }
        if(dp[map.get(curr)][k]) {
            return false;
        }
        if(map.containsKey(curr+k+1)) {
           if(rec(curr+k+1, k+1, stones, map, dp)) {
            return true;
           }
           dp[map.get(curr+k+1)][k+1]=true;
        }
        if(map.containsKey(curr+k)) {
            if(k!=0) {
           if(rec(curr+k, k, stones, map, dp)) {
            return true;
           }
           dp[map.get(curr+k)][k]=true;
            }
        }
        if(map.containsKey(curr+k-1)) {
            if(k-1!=0) {
           if(rec(curr+k-1, k-1, stones, map, dp)) {
            return true;
           }
           dp[map.get(curr+k-1)][k-1]=true;
            }
        }
        return false;
    }
    public boolean canCross(int[] stones) {
         HashMap<Integer, Integer> map= new HashMap<>();
         boolean [][] dp= new boolean[stones.length][stones.length+1];
         
         for(int i=0;i<stones.length;i++) {
            map.put(stones[i],i);
         }
         return rec(0,0,stones,map,dp);

    }
}















