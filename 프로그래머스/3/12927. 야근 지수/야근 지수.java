import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: works) {
            pq.add(i);
        }
        
        while(n > 0) {
            if(pq.isEmpty()) return 0;
            int tmp = pq.poll();
            if(tmp > 1) {
                pq.add(tmp - 1);
            }
            n--;
        }
        
        for(int i: pq) {
            answer += Math.pow(i, 2);
        }
        
        return answer;
    }
}