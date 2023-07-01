import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++) {
            // 3일까지는 그냥 확인
            if(i < k) {
                pq.offer(score[i]);
                answer[i] = pq.peek();
                continue;
            }
            // 3일 이후 비교
            if(pq.peek() < score[i]) {
                pq.poll();
                pq.offer(score[i]);
                answer[i] = pq.peek();
            } else {
                answer[i] = pq.peek();
            }
        }
        return answer;
    }
}