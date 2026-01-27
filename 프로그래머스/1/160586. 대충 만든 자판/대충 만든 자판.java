import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // 각 키맵을 돌면서 해당하는 키값에 접근할 수 있는 가장 적은 클릭 수를 저장(HashMap 사용, 조회시간 고려)
        Map<Character, Integer> kMap = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                // 도달하기 위한 클릭 횟수 최솟값 저장
                kMap.put(c, Math.min(kMap.getOrDefault(c, i + 1), i + 1));
            }
        }
        
        // 각 타겟을 돌며 도달하기 위한 최소 클릭 수 합산 / 맵에 없을 경우 -1 저장
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if(!kMap.containsKey(c)) {
                    sum = -1;
                    break;
                }
                sum += kMap.get(c);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}