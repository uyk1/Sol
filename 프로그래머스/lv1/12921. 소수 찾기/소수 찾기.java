import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 1; // n은 2 이상이므로.
        for(int i = 3; i <= n; i++) {
            if(check(i)) answer++;
        }
        return answer;
    }
    
    public static boolean check(int m) {
        for(int i = 2; i <= Math.sqrt(m); i++) {
            if(m % i == 0) return false;
        }
        return true;
    }
}