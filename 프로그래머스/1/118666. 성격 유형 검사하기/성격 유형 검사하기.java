import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] answer = new char[4];
        
        // 점수를 담을 맵
        Map<Character, Integer> map = new HashMap<>();
        
        // survey 탐색 -> choices 확인 -> 점수 적용
        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int c = choices[i];
            
            if(c < 4) map.put(a, map.getOrDefault(a, 0) + (4 - c));
            if(c > 4) map.put(b, map.getOrDefault(b, 0) + (c - 4));
        }
        
        // 성격 정하기
        answer[0] = map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T';
        answer[1] = map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F';
        answer[2] = map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M';
        answer[3] = map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N';
        
        return new String(answer);
    }
}