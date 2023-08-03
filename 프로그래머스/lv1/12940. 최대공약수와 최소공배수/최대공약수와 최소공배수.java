import java.math.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n == m) {
            answer[0] = n;
            answer[1] = n;
            return answer;
        }
        
        int max = Math.max(n, m), min = Math.min(n, m);
        for(int i = 1; i <= min; i++) {
            if(n % i == 0 && m % i == 0) answer[0] = i;
        }
        
        int b = max; // 최대 공약수
        int mult = 1;
        while(b % min != 0) {
            mult++;
            b = max * mult;
        }
        answer[1] = b;
        return answer;
    }
}