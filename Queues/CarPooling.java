package Queues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)-> {
            return a[1]-b[1];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            return a[2]-b[2];
        });
        int cap=0;
        for(int i=0;i<trips.length;i++) {
            cap+=trips[i][0];
            while(pq.peek()!=null && pq.peek()[2]<=trips[i][1]) {
                    cap-=pq.poll()[0];
                }
            pq.add(trips[i]);
            if(cap>capacity) {
                return false;
            }
        }
        return true;
}
}
