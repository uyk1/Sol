import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: emergency) pq.offer(i);
        int rank = 1;
        while(!pq.isEmpty()) {
            for(int i = 0; i < emergency.length; i++) {
                if(pq.peek() == emergency[i]) {
                    answer[i] = rank;
                    pq.poll();
                    rank++;
                    break;
                } 
            }
        }
        return answer;
    }
}