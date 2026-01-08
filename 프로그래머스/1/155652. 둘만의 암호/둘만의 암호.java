import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        // 알파벳 26자
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] sArr = s.toCharArray();
        Set<Character> skipSet = new HashSet<>();
        
        for(char c : skip.toCharArray()) skipSet.add(c);
        
        for(int i = 0; i < s.length(); i++) {
            char c = sArr[i];
            int cnt = 0; // index만큼 뒤로 갔는지 카운트
            int idx = alphabet.indexOf(c); // 위치
            while(cnt < index) {
                idx++;
                if(idx > 25) idx -= 26;
                if(skipSet.contains(alphabet.charAt(idx))) continue;
                cnt++;
            }
            sArr[i] = alphabet.charAt(idx);
        }
        
        return new String(sArr);
    }
}