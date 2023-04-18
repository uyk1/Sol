import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위 큐에 대기목록 집어넣기(내림차순 정렬, 중요도 높은 것부터)
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: priorities) pq.offer(i); 
        // 큐에서 peek한 값이 priorities[i]와 일치하면 answer++;
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    // 우선순위 더 높은 것 먼저 인쇄
                    pq.poll();
                    answer++;
                } 
            }
        }
        
        return answer;
    }
}