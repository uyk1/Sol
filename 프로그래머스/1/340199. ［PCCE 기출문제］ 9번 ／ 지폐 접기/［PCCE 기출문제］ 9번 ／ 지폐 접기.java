import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wmax = Math.max(wallet[0], wallet[1]);
        int wmin = Math.min(wallet[0], wallet[1]);
        
        int max = Math.max(bill[0], bill[1]);
        int min = Math.min(bill[0], bill[1]);
        
        while(wmax < max || wmin < min) {
            // 나누고 max min 다시 비교
            int tmp = max / 2;
            if(tmp < min) {
                max = min;
                min = tmp;
            } else {
                max = tmp;
            }
            answer++;
        }
        
        return answer;
    }
}