import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        int sum = Integer.parseInt(s1+s2);
        answer = sum;
        
        int mul = 2*a*b;
        if(answer < mul) answer=mul;
        return answer;
    }
}