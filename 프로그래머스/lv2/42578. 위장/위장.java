import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //종류만 확인하면 되므로 Integer 이용해 ++
        Map<String, Integer> hm = new HashMap<>();
        for(String[] s: clothes) {
            hm.put(s[1], hm.getOrDefault(s[1], 0)+1);
        }
        for(Map.Entry<String, Integer> entry: hm.entrySet()) {
            int tmp = entry.getValue();
            //안 입는 경우도 포함한 경우의 수
            answer *= (tmp+1);
        }
        answer--; //아무것도 입지 않은 경우는 없음.
        return answer;
    }
}