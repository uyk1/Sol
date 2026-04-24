import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 각 미사일 경로가 끝나는 지점 순으로 정렬
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int last = 0;
        
        for(int i = 0; i < targets.length; i++) {
            if(last <= targets[i][0]){
                answer++;
                last = targets[i][1];
            };
        }
        
        return answer;
    }
}