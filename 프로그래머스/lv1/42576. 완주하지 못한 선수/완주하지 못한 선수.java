import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        for(String str: participant) hm.put(str, hm.getOrDefault(str, 0)+1);
        for(String str: completion) hm.put(str, hm.get(str)-1);
        for(Map.Entry<String, Integer> e: hm.entrySet()) {
            if(e.getValue() != 0) {
                answer = e.getKey();
                break;
            }
        }
        return answer;
    }
}