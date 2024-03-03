import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            cnt1[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); i++) {
            cnt2[Y.charAt(i) - '0']++;
        }
        
        boolean chk = false; // 짝꿍이 존재하는지 확인
        
        for(int i = 9; i >= 0; i--) {
            if(!chk && i == 0) {
                if(cnt1[i] == 0 || cnt2[i] == 0) return "-1";
                return "0";
            }
            if(cnt1[i] == 0 || cnt2[i] == 0) continue;
            chk = true;
            for(int j = 0; j < Math.min(cnt1[i], cnt2[i]); j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}