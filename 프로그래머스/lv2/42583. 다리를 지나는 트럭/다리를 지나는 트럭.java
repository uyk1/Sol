import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 트럭 전부가 다리를 건너는 데 걸린 시간
        Queue<Integer> q = new LinkedList<>(); // 다리
        int sum = 0; // 현재 다리 위에 올라온 트럭 무게의 합
        
        //트럭은 차례대로 이동
        for(int i = 0; i < truck_weights.length; i++) {
            while(true) { // 이번 트럭을 담고 나면 break;
                int truck = truck_weights[i];
                // 만약 큐가 비어있다면?
                if(q.isEmpty()) {
                    q.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                // 큐가 가득 찼다면?
                else if(q.size() == bridge_length) {
                    sum -= q.poll();
                }
                // 큐가 아직 다 차지 않았다면?
                else {
                    // 다음 트럭의 무게와 현재 다리에 오른 트럭들의 무게 합 확인
                    if(sum + truck <= weight) {
                        q.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else {
                        q.offer(0);
                        answer++;
                    }
                }
            }
        }
        // 마지막 차 건너기
        answer += bridge_length;
        return answer;
    }
}
