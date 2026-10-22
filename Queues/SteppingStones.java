package Queues;

import java.util.PriorityQueue;

public class SteppingStones {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> {
            return b-a;
        } );
        for(int i=0;i<stones.length;i++) {
            pq.add(stones[i]);
        }
        while(pq.size()>1) {
            int s1=pq.poll();
            int s2=pq.poll();
            if((s1-s2)!=0) {
                pq.add(Math.abs(s1-s2));
            }
        }
        if(pq.size()!=0) {
            return pq.poll();
        }
        else {
            return 0;
        }

    }
}

