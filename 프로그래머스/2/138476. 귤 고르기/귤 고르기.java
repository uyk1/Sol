import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0; // 답
        int cnt = 0; // 담은 귤의 개수
        
        // key : 귤 크기, value : 개수
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            // 이미 같은 크기의 귤이 있었는지 확인하고 카운트 추가
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // List에 Map의 Value 값 옮기기
        List<Integer> list = new ArrayList<>(map.values());
        
        // 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        // 반복문을 돌며 합계 개수 확인
        for(int i : list) {
            cnt += i;
            if(cnt < k) {
                answer++;
            } else {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}