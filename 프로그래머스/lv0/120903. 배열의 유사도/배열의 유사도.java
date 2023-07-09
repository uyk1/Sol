import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Map<String, String> hm = new HashMap<>();
        boolean chk = s1.length <= s2.length;
        if(chk) {
            for(String str: s1) {
                if(!hm.containsKey(str)) hm.put(str, "");
            }
            for(String str: s2) {
                if(hm.containsKey(str)) answer++;
                if(answer == s1.length) return s1.length;
            }
        } else {
            for(String str: s2) {
                if(!hm.containsKey(str)) hm.put(str, "");
            }
            for(String str: s1) {
                if(hm.containsKey(str)) answer++;
                if(answer == s2.length) return s2.length;
            }
        }
        
        return answer;
    }
}