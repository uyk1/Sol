import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int index = 0; // 
        int count = 0; // 처리한 요청의 개수
        int sum = 0; // 종료 - 요청 시간 합계
        int end = 0; // 현재 작업 중인 job의 종료시간
        // 정렬 (요청시간)
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        // 우선순위 (소요시간)
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 반복문
        while(count != jobs.length) {
            // index가 전체 작업 개수 미만이고 jobs[index]의 요청시간이
            // 현재 작업 중인 job의 종료시간보다 작을 경우 큐에 삽입
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.offer(jobs[index++]);
            }
            
            // 비어있는 경우 end를 변경
            // 다음 반복 때 큐에 삽입됨
            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                count++;
                int[] tmp = pq.poll();
                sum += (end + tmp[1]) - tmp[0];
                end += tmp[1];
            }
        }
        answer = sum / count;
        
        return answer;
    }
}
// jobs 배열 정렬 1. 요청 시간 2. 소요 시간
// 우선순위큐 생성
// 첫 번째 작업 큐에 삽입
// while 반복문으로 작업이 끝날 때까지 들어오는 요청을 큐에 삽입
// 만약 요청이 다 해결되지 않았는데 큐가 비었을 경우, 현재 진행되는 작업이 끝난 후 새로운 작업 시작