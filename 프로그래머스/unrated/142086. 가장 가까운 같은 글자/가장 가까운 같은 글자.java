import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(arr[i])) {
                answer[i] = i - map.get(arr[i]);
                map.put(arr[i], i);
                continue;
            }
            map.put(arr[i], i);
            answer[i] = -1;
        }
        
        return answer;
    }
}
// getOrDefault()를 활용하면 좋았을 것.