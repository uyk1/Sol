import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < my_string.length(); i++) {
            String tmp = my_string.substring(i, i+1);
            if(map.containsKey(tmp)) continue;
            map.put(tmp, "");
            answer += tmp;
        }
        return answer;
    }
}