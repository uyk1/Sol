import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = "";
        while(n > 0) {
            int a = n / 3;
            int b = n % 3;
            tmp = String.valueOf(b) + tmp;
            n = a;
        }
        for(int i = 0; i < tmp.length(); i++) answer += (tmp.charAt(i) - '0') * Math.pow(3, i);
        
        return answer;
    }
}