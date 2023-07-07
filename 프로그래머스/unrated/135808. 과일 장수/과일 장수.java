import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // primitive 타입을 wrapper 클래스로 박싱해주어야 reverseOrder()메서드 사용 가능.
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        for(int i = m-1; i < (score.length / m) * m; i += m){
            answer += tmp[i] * m;
        }
        
        return answer;
    }
}
// k: 최고점  m: 상자당 담아야할 개수  score: 사과의 점수
// 가능한 많은 사과를 팔아야 함 -> 박스는 score.length / m 개.
// 내림차순 정렬 후 상자 만들기.