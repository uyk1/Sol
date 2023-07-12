import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < str.length(); i++) {
            pq.add(str.substring(i, i+1));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll());
        answer = Long.parseLong(sb.toString());
            
        return answer;
    }
}